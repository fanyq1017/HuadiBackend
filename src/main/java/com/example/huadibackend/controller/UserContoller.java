package com.example.huadibackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.User;
import com.example.huadibackend.service.UserService;
import com.example.huadibackend.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.util.Objects;

@RestController
public class UserContoller {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult<Object> login(String username, String password, HttpSession session) {
        User userRes = userService.userLogin(username, password);

        if (userRes== null || userRes.getValid() == 0) {
            return new JsonResult<Object>(400, "登陆失败");        }
        session.setAttribute("uid",userRes.getUId());
        session.setAttribute("username",userRes.getUsername());
        System.out.println(username);

        return new JsonResult<Object>(200, userRes);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult<String> add(User user) {
        user.setType(0);
        user.setValid(1);
        int isRepeat = userService.checkUsername(user.getUsername());
        if (isRepeat !=0) { return new JsonResult<String>(400,"账号已存在");}
        int res = userService.insertUser(user);
        System.out.println(res);
        if (res == 1) {
            return new JsonResult<String>(200,"添加成功");
        }else {
            return new JsonResult<String>(400,"添加失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateType" ,method = RequestMethod.GET)
    public JsonResult<String> updateType(@RequestParam(value = "uId")Integer uId,@RequestParam(value = "type")Integer type) {
                int res = userService.updateTypeById(type,uId);
                if (res ==1 ) { return new JsonResult<>(200,"修改成功");}
                else {return new JsonResult<>(400,"修改失败");}
    }

    @ResponseBody
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public JsonResult<Object> adminLogin (String username,String password,HttpSession session) {
        User userRes = userService.userLogin(username, password);
        if (userRes !=null) {
            if (userRes.getType() < 1) {
                return new JsonResult<>(400, "账户权限不足");
            } else {
                session.setAttribute("uid", userRes.getUId());
                session.setAttribute("username", userRes.getUsername());
                System.out.println(username);
                System.out.println(userRes.getUId());
                return new JsonResult<Object>(200, userRes);
            }
            }else  {
                     return new JsonResult<>(400,"账户不存在");
                     }
        }

    @ResponseBody
    @RequestMapping(value = "/Profile",method = RequestMethod.GET)
    public JsonResult<User> getProfile(Integer uId) {
         User user = userService.selectById(uId);
         return new JsonResult<User>(200,user);
    }

    @ResponseBody
    @RequestMapping(value = "/amendProfile" , method = RequestMethod.POST)
    public JsonResult<String> amendProfile(User user){
        System.out.println(user);
        int isRepeat = userService.checkUsername(user.getUsername());
        if (Objects.equals(user.getUsername(), userService.selectById(user.getUId()).getUsername())) isRepeat--;
        if (isRepeat !=0) { return new JsonResult<String>(400,"账号已存在");}
        System.out.println(user);
        user.setValid(1);
        int res = userService.updateUserInformation(user);
        System.out.println(user);
          if (res ==1 ) { return new JsonResult<>(200,"修改成功");}
          else {return new JsonResult<>(400,"修改失败");}
    }

    @ResponseBody
    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public JsonResult<Object> getUserList(@RequestParam(value = "page")Integer current,@RequestParam(value = "count")Integer size){

        Page<User> page = new Page<>(current,size);
        IPage<User> iPage= userService.ShowUserInformation(page);
        return new JsonResult<>(200,iPage);
    }

    @ResponseBody
    @RequestMapping(value ="/deleteUser",method = RequestMethod.POST)
    public JsonResult<String> deleteUser(Integer[] uIds){
        Integer valid =0 ;//0表示正常1表示异常
        int cnt =0;
        try {
            for (Integer uId:uIds) {
                if (userService.updateValidByID(uId) == 1 )
                    cnt ++ ;
            }
            if (cnt == uIds.length){
                return new JsonResult<String>(200, "删除成功!");
            }
            return new JsonResult<String>(400, "存在无效ID");
        }catch(Exception e) {
            e.printStackTrace();
            return new JsonResult<String>(400, "删除异常!");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/searchUsername",method = RequestMethod.POST)
    public JsonResult<Object> searchUsername (@RequestParam(value = "page")Integer current,
                                              @RequestParam(value = "count")Integer size,
                                              @RequestParam(value = "username") String username){
            Page<User> page =new Page<>(current,size);
            IPage<User> iPage = userService.searchByUsername(page,username);
            return new JsonResult<>(200,iPage);
    }








}


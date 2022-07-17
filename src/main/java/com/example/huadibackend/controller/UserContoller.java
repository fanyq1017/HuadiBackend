package com.example.huadibackend.controller;

import com.example.huadibackend.entity.User;
import com.example.huadibackend.service.UserService;
import com.example.huadibackend.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserContoller {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult<Object> login(String username, String password, HttpSession session) {
        User userRes = userService.userLogin(username, password);
        session.setAttribute("uid",userRes.getUId());
        session.setAttribute("username",userRes.getUsername());
        System.out.println(username);
        if (userRes!= null) {
            return new JsonResult<Object>(200, userRes);
        }
        return new JsonResult<Object>(400, "登陆失败");
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult<String> add(User user) {
        user.setType(0);
        user.setValid(1);
        int isRepeat = userService.checkUsername(user.getUsername());
        if (isRepeat !=0) { return new JsonResult<String>(200,"账号已存在");}
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





}


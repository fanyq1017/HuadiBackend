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
    public JsonResult<String> login(String username, String password, HttpSession session) {
        User userRes = userService.userLogin(username, password);
        session.setAttribute("uid",userRes.getUId());
        session.setAttribute("username",userRes.getUsername());
        System.out.println(username);
        if (userRes != null) {
            return new JsonResult<String>(200, "请求成功");
        }
        return new JsonResult<String>(400, "请求失败");
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





}


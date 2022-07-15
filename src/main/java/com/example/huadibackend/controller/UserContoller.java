package com.example.huadibackend.controller;

import com.example.huadibackend.entity.User;
import com.example.huadibackend.service.UserService;
import com.example.huadibackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

public class UserContoller {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<String> login(String name, String password, HttpSession session) {
        User userRes = userService.userLogin(name, password);
        session.setAttribute("uid",userRes.getUId());
        session.setAttribute("username",userRes.getUsername());
        if (userRes != null) {
            return new JsonResult<String>(200, "请求成功");
        }
        return new JsonResult<String>(400, "请求失败");
    }

    @PostMapping("/Register")
    @ResponseBody
    public JsonResult<String> add(@RequestBody User user) {
        int res = userService.insertUser(user);
        if (res == 1) {
            return new JsonResult<String>(200,"添加成功");
        }else {
            return new JsonResult<String>(400,"添加失败");
        }
    }






}


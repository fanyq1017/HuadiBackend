package com.example.huadibackend.service;

import com.example.huadibackend.entity.User;

import java.util.List;

public interface UserService {

    User selectById(int userId);

    void deleteById(int userId);

    void insertUser(User user);  //通常用于注册使用，表单返回

    void updateUserInformation(User user);

    List<User> ShowUserInformation(); //返回所有信息用于管理员进行管理

}

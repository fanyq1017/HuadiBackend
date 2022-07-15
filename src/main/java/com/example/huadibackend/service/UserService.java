package com.example.huadibackend.service;

import com.example.huadibackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User selectById(int userId);

    void deleteById(int userId);

    int insertUser(User user);  //通常用于注册使用，表单返回

    void updateUserInformation(User user);

    List<User> ShowUserInformation(); //返回所有信息用于管理员进行管理

    public User userLogin(String username, String password);

}

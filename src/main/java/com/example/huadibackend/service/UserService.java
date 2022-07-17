package com.example.huadibackend.service;

import com.example.huadibackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User selectById(Integer uid);//INTEGER和int千万要区分

    int deletebyId(Integer uid);

    int insertUser(User user);  //通常用于注册使用，表单返回

    int updateUserInformation(User user);

    List<User> ShowUserInformation(); //返回所有信息用于管理员进行管理

    public User userLogin(String username, String password);

    int checkUsername(String username);

    int updateTypeById(Integer type, Integer uid);

}

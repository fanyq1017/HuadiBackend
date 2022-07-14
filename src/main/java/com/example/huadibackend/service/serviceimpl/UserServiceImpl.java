package com.example.huadibackend.service.serviceimpl;

import com.example.huadibackend.entity.User;
import com.example.huadibackend.mapper.UserMapper;
import com.example.huadibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectById(int userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public void deleteById(int userId) {
        userMapper.deleteById(userId);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUserInformation(User user) {
        userMapper.updateUserInformation(user);
    }

    @Override
    public List<User> ShowUserInformation() {
        return userMapper.ShowUserInformation();
    }
}

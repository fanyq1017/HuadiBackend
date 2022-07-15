package com.example.huadibackend.service.serviceimpl;

import com.example.huadibackend.entity.User;
import com.example.huadibackend.mapper.UserMapper;
import com.example.huadibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return 0;
    }

    @Override
    public void updateUserInformation(User user) {
        userMapper.updateUserInformation(user);
    }

    @Override
    public List<User> ShowUserInformation() {
        return userMapper.ShowUserInformation();
    }

    @Override
    public User userLogin(String username, String password) {
        return userMapper.Login(username,password);
    }

}

package com.example.huadibackend.service.serviceimpl;

import com.example.huadibackend.entity.User;
import com.example.huadibackend.mapper.UserMapper;
import com.example.huadibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectById(Integer uid) {
        return userMapper.findById(uid);
    }

    @Override
    public int deletebyId(Integer uid) {
       return userMapper.deletebyId(uid);
    }

    @Override
    public int insertUser(User user) {
       return userMapper.insertUser(user);
    }

    @Override
    public int updateUserInformation(User user) {
        return userMapper.updateUserInformation(user);
    }

    @Override
    public List<User> ShowUserInformation() {
        return userMapper.ShowUserInformation();
    }

    @Override
    public User userLogin(String username, String password) {
       return userMapper.Login(username,password);
    }

    @Override
    public int checkUsername(String username) {
        Map<String, Object> map =new HashMap<String, Object>();
        map.put("username",username);
        List<User> useres = userMapper.selectByMap(map);
        int size = useres.size();
        return (size);
    }

    @Override
    public int updateTypeById(Integer type, Integer uid) {
        return userMapper.updateStateById(type,uid);
    }

}

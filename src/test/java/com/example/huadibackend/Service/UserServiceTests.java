package com.example.huadibackend.Service;

import com.example.huadibackend.entity.User;
import com.example.huadibackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = new User(1,"lkc","123",1,0,"123");
    }

    @Test
    public void add()  {

        User user = new User(null, "aaa","123",1,0,"123");
        userService.insertUser(user);
    }

    @Test
    public void update()  {
        User user =new User(1, "aaa","123456",1,0,"123");
        userService.updateUserInformation(user);
    }

    @Test
    public void delete() {

        userService.deleteById(1);

    }
}

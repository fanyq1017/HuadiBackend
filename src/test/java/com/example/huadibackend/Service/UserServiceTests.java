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
        for (int i=0;i<10;i++) {
            User user = new User(null, "lkc", "lkc123", 1, 1, "123177888");
            userService.insertUser(user);
        }
    }

    @Test
    public void update()  {
        User user =new User(1, "aaa","123456",1,0,"123");
        userService.updateUserInformation(user);
    }

    @Test
    public void delete() {
        Integer uid = 5;
        userService.deletebyId(uid);
    }
    @Test
    public void Check()  {
        int isRepeat = userService.checkUsername("fyq");
        System.out.println(isRepeat);
    }

    @Test
    public void updateById(){
         userService.updateTypeById(0,7);
    }

    @Test
    public void select(){
        Integer uid =2;
        System.out.println(uid);
        System.out.println( userService.selectById(uid));
    }

    @Test
    public void selectnotnull(){
        Integer uid =100;
        System.out.println(uid);
       User user=  userService.selectById(uid);
        System.out.println(user == null );
    }

}

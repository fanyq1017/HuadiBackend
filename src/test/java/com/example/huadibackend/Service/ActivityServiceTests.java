package com.example.huadibackend.Service;


import com.example.huadibackend.entity.Activity;
import com.example.huadibackend.service.ActivityService;
import com.example.huadibackend.service.serviceimpl.ActivityServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ActivityServiceTests {

    @Autowired
    private ActivityService activityService;

    @Test
    public void add(){
        Activity activity = new Activity(1,"name","image","information");
        int result = activityService.add(activity);
        System.out.println("ok.");

    }
}

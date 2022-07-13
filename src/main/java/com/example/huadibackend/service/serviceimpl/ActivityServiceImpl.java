package com.example.huadibackend.service.serviceimpl;

import com.example.huadibackend.entity.Activity;
import com.example.huadibackend.mapper.ActivityMapper;
import com.example.huadibackend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    public ActivityMapper activityMapper;

    @Override
    public int add(Activity activity) {
        return activityMapper.add(activity);
    }
}

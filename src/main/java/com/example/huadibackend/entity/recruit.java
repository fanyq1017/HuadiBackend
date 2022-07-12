package com.example.huadibackend.entity;

import lombok.Data;

@Data
public class recruit {
    private int id;
    private String name;
    private int preference;  //'希望参与的志愿活动类型,如0代表关爱老人1代表呵护儿童等'
    private String intro;  // '参加招募的志愿者的自我介绍'

}

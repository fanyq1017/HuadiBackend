package com.example.huadibackend.entity;

import lombok.Data;

@Data
public class Video {
    private int id;
    private int type;
    private String location;
    private String intro;
    private String image;
}

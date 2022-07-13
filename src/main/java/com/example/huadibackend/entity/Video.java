package com.example.huadibackend.entity;

import lombok.Data;

@Data
public class Video {
    private int videoId;
    private int type;
    private String location;
    private String intro;
    private String image;
}

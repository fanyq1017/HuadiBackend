package com.example.huadibackend.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Video {
    private int vId;
    private String vTitle;
    private int vType;
    private String vLocation;
    private Timestamp vPublishtime;
    private String vIntro;
    private String vImage;
}

package com.example.huadibackend.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Video {
    private Integer vId;
    private String vTitle;
    private Integer vType;
    private String vLocation;
    private Timestamp vPublishtime;
    private String vIntro;
    private String vImage;
    private Integer vState;
}

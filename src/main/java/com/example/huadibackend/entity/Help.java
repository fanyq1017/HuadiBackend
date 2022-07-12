package com.example.huadibackend.entity;

import lombok.Data;

@Data
public class Help {
    private int id;
    private String helper;
    private String helped;
    private int type;
    private String intro;

}

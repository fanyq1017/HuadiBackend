package com.example.huadibackend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class issue {
    private int id;
    private String location;
    private String name;
    private Date time;
}

package com.example.huadibackend.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int type;
    private int valid;
    private String telephone;
}

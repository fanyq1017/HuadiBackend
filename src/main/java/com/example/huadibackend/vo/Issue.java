package com.example.huadibackend.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Issue {
    private int issueId;
    private String location;
    private String name;
    private Date time;
}

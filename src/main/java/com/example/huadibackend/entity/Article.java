package com.example.huadibackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private int id;
    private String title;
    private int uid;
    private String mdContent;
    private String htmlContent;
    private int state;
    private Timestamp publishDate;
    private Timestamp editTime;
    private int type;


}

package com.example.huadibackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id;
    private String title;
    private Integer uId;
    private Timestamp publishDate;
    private Timestamp editTime;
    private String mdContent;
    private String htmlContent;
    private Integer state;//0未发表1已发表2删除
    private Integer type;
    private String nickname;



}

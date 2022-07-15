package com.example.huadibackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


/*
https://chinavolunteer.mca.gov.cn/NVSI/LEAP/site/index.html#/projectInfo/6C0A10D9360246DA925449445DBB326C/510923000000000000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoluntaryProject {
    private Integer pId;//项目ID
    private String pName;//项目名称
    private Integer pType;//项目类型
    private String pLocation;//项目地点
    private LocalDate pProjectStart;//项目起始时间
    private LocalDate pProjectEnd;//项目终止时间
    private LocalDateTime pPublishDate;//发布时间
    private LocalDate recruitStart;//招聘开始时间
    private LocalDate recruitEnd; //招聘截止日期
    private String serveClient ;//服务对象
    private String pInfo;//志愿项目信息
}

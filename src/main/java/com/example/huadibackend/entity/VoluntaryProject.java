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
    private String name;
    private String projectId;
    private LocalDate projectStartTime;//项目起始时间
    private LocalDate projectEndTime;//项目终止时间
    private LocalDateTime publishTime;//发布时间
    private LocalDate recruitmentStartTime;//招聘开始时间
    private LocalDate recruitmentEndTime; //招聘截止日期
    private String client ;//服务对象
    private String projectInfo;//志愿项目信息
}

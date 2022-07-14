package com.example.huadibackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
具体信息内涵见 https://chinavolunteer.mca.gov.cn/NVSI/LEAP/site/index.html#/project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoluntaryAttribute {
    private int area;
    private int classification;
    private int status;
    private int registrationScope;
    private int clients;
    private int population;
    private int ProjectId ;
}
/*
*
*
* */
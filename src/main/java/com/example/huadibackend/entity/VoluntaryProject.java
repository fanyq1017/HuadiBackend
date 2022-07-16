package com.example.huadibackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


/*
https://chinavolunteer.mca.gov.cn/NVSI/LEAP/site/index.html#/projectInfo/6C0A10D9360246DA925449445DBB326C/510923000000000000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("voluntary_project")
public class VoluntaryProject implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "p_id",type= IdType.AUTO)
    private Integer pId;//项目ID

    private String pImage;//封面url
    private String pName;//项目名称
    private Integer pType;//项目类型
    private String pLocation;//项目地点
    private Timestamp pProjectstart;//项目起始时间
    private Timestamp pProjectend;//项目终止时间
    private Timestamp pPublishdate;//发布时间
    private Timestamp pEdittime;//修改时间
    private Timestamp pRecruitstart;//招聘开始时间
    private Timestamp pRecruitend; //招聘截止日期
    private String pServeclient ;//服务对象
    private String pInfo;//志愿项目信息
    private String pPeople;//负责人
    private String pTelephone;//负责人电话号码
    private Integer pProvinceregioncode;//省份邮编号
    private Integer pCityregioncode;//市邮编号
    private Integer pDistrictregioncode;//区邮编号

}

package com.example.huadibackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/*
具体信息内涵见 https://chinavolunteer.mca.gov.cn/NVSI/LEAP/site/index.html#/project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("voluntary_attribute")
public class VoluntaryAttribute implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "va_id",type= IdType.AUTO)
    private Integer va_id;

    private Integer serveType;
    private Integer projectState;
    private Integer applyType;
    private Integer serveClient;
    private Integer peopleNum;
    private Integer regionCode;
    private Integer pId;
}
/*
*
*
* */
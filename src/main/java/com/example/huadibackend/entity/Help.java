package com.example.huadibackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@TableName(value = "help")
@AllArgsConstructor
@NoArgsConstructor
public class Help {

    @TableId(value = "h_id",type = IdType.AUTO)
    private Integer hId;

    private String hHelper;
    private String hHelpertel;
    private String hHelpedtel;
    private Timestamp hPublishdate;
    private String hHelped;
    private Integer hType;//0未完成1已完成
    private String hIntro;

}

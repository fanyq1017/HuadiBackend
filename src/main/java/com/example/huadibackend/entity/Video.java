package com.example.huadibackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "video")
public class Video {
    @TableId(value = "v_id",type = IdType.AUTO)
    private Integer vId;

    private String vTitle;
    private Integer vType;
    private String vLocation;
    private Timestamp vPublishtime;
    private String vIntro;
    private String vImage;
    private Integer vState;
}

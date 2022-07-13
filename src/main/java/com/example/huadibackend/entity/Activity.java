package com.example.huadibackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private int activityId;// NOT SURE id format
    private String activityName;
    private String activityImage;
    private String activityInformation;

}

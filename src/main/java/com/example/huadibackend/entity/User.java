package com.example.huadibackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uId;
    private String username;
    private String password;
    private Integer type;
    private Integer valid;
    private String telephone;
}

package com.example.huadibackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Help;
import com.example.huadibackend.mapper.HelpMapper;

public interface HelpService {
    IPage<Help> viewHelpByType(Page<Help> page,Integer state);//分页查询帮扶页面

    int insert(Help help);

    int updateInfo(Help help);

    int assist(Integer hId,String hHelper,String hHelpedtel);

    Help viewById(Integer hId);

}

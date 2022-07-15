package com.example.huadibackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryAttribute;
import com.example.huadibackend.entity.VoluntaryProject;
import org.springframework.stereotype.Service;

public interface VoluntaryAttributeService {
    IPage<Integer> findByAttribute(Page<Integer> page,VoluntaryAttribute voluntaryAttribute);

}

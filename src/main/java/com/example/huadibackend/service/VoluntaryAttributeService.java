package com.example.huadibackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryAttribute;
import com.example.huadibackend.entity.VoluntaryProject;
import org.springframework.stereotype.Service;

public interface VoluntaryAttributeService {
    IPage<VoluntaryProject> findByAttribute(VoluntaryAttribute voluntaryAttribute);

    IPage<VoluntaryProject> findByAttribute(Page<VoluntaryProject> page, VoluntaryAttribute voluntaryAttribute);
}

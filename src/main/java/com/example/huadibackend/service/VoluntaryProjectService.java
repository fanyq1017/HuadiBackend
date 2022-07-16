package com.example.huadibackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryProject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface VoluntaryProjectService {
    int addProject(VoluntaryProject voluntaryProject);

    int updateById (VoluntaryProject voluntaryProject);

    int deleteById (Integer Id);

    VoluntaryProject selectById(Integer Id);

    IPage<VoluntaryProject> selectPageByUID(Page<VoluntaryProject> page, Integer UID);

    IPage<VoluntaryProject> selectPageByRegioncode(Page<VoluntaryProject> page, Integer provinceRegionCode,Integer cityRegionCode,Integer districtRegionCode);

}

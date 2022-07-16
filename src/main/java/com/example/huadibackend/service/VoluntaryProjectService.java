package com.example.huadibackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryProject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface VoluntaryProjectService {
    int addProject(VoluntaryProject voluntaryProject);

    int updateById (VoluntaryProject voluntaryProject);

    int deleteById (Integer Id);

    VoluntaryProject selectById(Integer Id);

    IPage<VoluntaryProject> selectPageByUID(Page<VoluntaryProject> page, Integer UID);
    }

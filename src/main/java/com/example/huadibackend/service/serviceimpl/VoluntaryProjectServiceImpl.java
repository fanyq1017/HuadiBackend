package com.example.huadibackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryProject;
import com.example.huadibackend.mapper.VoluntaryProjectMapper;
import com.example.huadibackend.service.VoluntaryProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VoluntaryProjectServiceImpl implements VoluntaryProjectService {
    @Autowired
    VoluntaryProjectMapper voluntaryProjectMapper;

    @Override
    public int addProject(VoluntaryProject voluntaryProject){
       return voluntaryProjectMapper.insert(voluntaryProject);
    }

    @Override
    public int updateById(VoluntaryProject voluntaryProject) {
        return voluntaryProjectMapper.updateById(voluntaryProject);
    }

    @Override
    public int deleteById(Integer Id) {
        return voluntaryProjectMapper.deleteById(Id);
    }

    @Override
    public VoluntaryProject selectById(Integer Id){
        return voluntaryProjectMapper.selectById(Id);
    }

    @Override
    public IPage<VoluntaryProject> selectPageByUID(Page<VoluntaryProject> page,Integer UID) {
        QueryWrapper<VoluntaryProject> qw =new QueryWrapper<>();
        qw.eq("u_id",UID);
        return voluntaryProjectMapper.selectPage(page,qw);
    }

    @Override
    public IPage<VoluntaryProject> selectPageByRegioncode(Page<VoluntaryProject> page, Integer provinceRegionCode, Integer cityRegionCode, Integer districtRegionCode) {
            QueryWrapper<VoluntaryProject> qw = new QueryWrapper<>();
            qw.eq("p_provinceregioncode",provinceRegionCode);
            qw.eq("p_cityregioncode",cityRegionCode);
            qw.eq("p_districtregioncode",districtRegionCode);
            return voluntaryProjectMapper.selectPage(page,qw);


    }


}

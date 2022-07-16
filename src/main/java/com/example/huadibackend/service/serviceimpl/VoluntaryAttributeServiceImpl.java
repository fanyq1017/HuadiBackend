package com.example.huadibackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryAttribute;
import com.example.huadibackend.entity.VoluntaryProject;
import com.example.huadibackend.mapper.VoluntaryAttributeMapper;
import com.example.huadibackend.service.VoluntaryAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntaryAttributeServiceImpl implements VoluntaryAttributeService {
    @Autowired
    VoluntaryAttributeMapper voluntaryAttributeMapper;


    @Override
    public IPage<VoluntaryProject> findByAttribute(Page<VoluntaryProject> page, VoluntaryAttribute voluntaryAttribute) {
         QueryWrapper<VoluntaryAttribute> qw = new QueryWrapper<>();

        //通过按钮查询，如果不是全部，则进行字段匹配
        qw.eq(voluntaryAttribute.getServeType()!= 0, "serve_type",voluntaryAttribute.getServeType());
        qw.eq(voluntaryAttribute.getProjectState()!= 0, "project_state",voluntaryAttribute.getProjectState());
        qw.eq(voluntaryAttribute.getRegionCode()!= 0, "region_code",voluntaryAttribute.getRegionCode());
        qw.eq(voluntaryAttribute.getServeClient()!= 0, "serve_client",voluntaryAttribute.getServeClient());
        qw.eq(voluntaryAttribute.getPeopleNum()!= 0, "people_num",voluntaryAttribute.getPeopleNum());
        qw.eq(voluntaryAttribute.getApplyType()!=0,"apply_type",voluntaryAttribute.getApplyType());

        //通过构建的wrapper返回符合条件的元组
        IPage<VoluntaryProject> iPage = voluntaryAttributeMapper.findByAttribute(page,qw);
        return iPage;//名字一个是驼峰一个是首字母大写一定要规范到位
    }

    @Override
    public int insert(VoluntaryAttribute voluntaryAttribute) {
        return voluntaryAttributeMapper.insert(voluntaryAttribute) ;//basemapper.insert的底层逻辑就是把类名转化称驼峰（看看是否开camel）然后用其中的创建好的量去填充### SQL: INSERT INTO voluntary_project  ( p_name, p_type, p_location, p_projectsstart, p_projectend, p_publishdate, recruitstart, recruitend, serveclient, p_info )  VALUES  ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )然后其中主键不填充需要在进一步设置

    }




}

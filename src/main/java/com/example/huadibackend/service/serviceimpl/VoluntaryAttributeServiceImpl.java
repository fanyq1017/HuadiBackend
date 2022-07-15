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

import java.util.List;

@Service
public class VoluntaryAttributeServiceImpl implements VoluntaryAttributeService {
    @Autowired
    VoluntaryAttributeMapper voluntaryAttributeMapper;


    @Override
    public IPage<Integer> findByAttribute(Page<Integer> page, VoluntaryAttribute voluntaryAttribute) {
         QueryWrapper<VoluntaryAttribute> qw = new QueryWrapper<>();

        //通过按钮查询，如果不是全部，则进行字段匹配
        qw.eq(voluntaryAttribute.getClassification()!= 0, "classification",voluntaryAttribute.getClassification());
        qw.eq(voluntaryAttribute.getStatus()!= 0, "status",voluntaryAttribute.getStatus());
        qw.eq(voluntaryAttribute.getRegistrationScope()!= 0, "registrationScope",voluntaryAttribute.getRegistrationScope());
        qw.eq(voluntaryAttribute.getClients()!= 0, "clients",voluntaryAttribute.getClients());
        qw.eq(voluntaryAttribute.getPopulation()!= 0, "population",voluntaryAttribute.getPopulation());

        //通过构建的wrapper返回符合条件的元组
        IPage<Integer> iPage = voluntaryAttributeMapper.findByAttribute(page,qw);
        return iPage;
    }


}

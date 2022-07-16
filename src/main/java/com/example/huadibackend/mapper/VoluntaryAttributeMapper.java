package com.example.huadibackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryAttribute;
import com.example.huadibackend.entity.VoluntaryProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VoluntaryAttributeMapper extends BaseMapper<VoluntaryAttribute>{
   @Select("select * from voluntary_project where p_id in "+
           "(select p_id " +
           "from voluntary_attribute " +
           "${ew.customSqlSegment})")// 这个多表查询也不知道可不可以这样写
   IPage<VoluntaryProject> findByAttribute(Page<VoluntaryProject> page, @Param("ew") QueryWrapper<VoluntaryAttribute> queryWrapper);
//需要返回什么东西

}

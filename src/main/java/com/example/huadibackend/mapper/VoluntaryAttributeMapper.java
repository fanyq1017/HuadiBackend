package com.example.huadibackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryAttribute;
import com.example.huadibackend.entity.VoluntaryProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VoluntaryAttributeMapper {
   @Select("select project_id " +
           "from VoluntaryAttribute" +
           "${ew.customSqlSegment}")// 这个多表查询也不知道可不可以这样写
   IPage<Integer> findByAttribute(Page<Integer> page, @Param("ew") QueryWrapper<VoluntaryAttribute> queryWrapper);
//需要返回什么东西
}

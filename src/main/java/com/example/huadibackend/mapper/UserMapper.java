package com.example.huadibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.huadibackend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where u_id = #{uid}")
    User findById(Integer uid);

    @Update("update user set valid =0 where u_id = #{uid}")
    int deletebyId(Integer uid);

    @Options(useGeneratedKeys = true)
    @Insert("insert into user(username,password,type,valid,telephone)" +
            "values(#{username},#{password},#{type},#{valid},#{telephone})")
    int insertUser(User user);  //通常用于注册使用，表单返回

    @Update("update user set username=#{username},password=#{password},type =#{type}," +
            "valid=#{valid},telephone = #{telephone} where u_Id = #{uId}")
    int updateUserInformation(User user);

    @Select("select * from user")
    List<User> ShowUserInformation(); //返回所有信息用于管理员进行管理

    @Select("select u_Id,username,telephone,type from user where username = #{username} and password = #{password}")
    User Login(String username, String password);

    @Update("update user set type =#{type} where u_id =#{uid}")
    int updateStateById(Integer type,Integer uid);
}

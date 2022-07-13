package com.example.huadibackend.mapper;

import com.example.huadibackend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where u_id = #{id}")
    User selectById(int userId);

    @Delete("delete from user where u_id = #{userId}")
    void deleteById(int userId);

    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into user(u_id,u_name,u_password,u_type,u_valid,u_telephone)" +
            "values(#{userId},#{name},#{password},#{type},#{valid},#{telephone})")
    void insertUser(User user);  //通常用于注册使用，表单返回

    @Update("update user set u_name=#{Username},u_password={password},u_type = {type}," +
            "u_valid=#{valid},u_telephone = #{telephone} where u_id = userId")
    void updateUserInformation(User user);

    @Select("select * from user")
    List<User> ShowUserInformation(); //返回所有信息用于管理员进行管理

}

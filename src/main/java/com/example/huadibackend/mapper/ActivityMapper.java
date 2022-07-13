package com.example.huadibackend.mapper;

import com.example.huadibackend.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ActivityMapper {

       @Options(useGeneratedKeys = true,keyProperty = "activityId")
       @Insert("insert into activity(a_id,a_name,a_image,a_information) values(#{activityId},#{activityName},#{activityImage},#{activityInformation})")
       int add(Activity activity);

//       @Select("select * from activity")
//        List<Activity> selectAll();


}

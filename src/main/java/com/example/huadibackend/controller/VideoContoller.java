package com.example.huadibackend.controller;

import com.example.huadibackend.entity.Video;
import com.example.huadibackend.service.VideoService;
import com.example.huadibackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/video")
public class VideoContoller {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Object> addVideo(Video video) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        video.setVPublishtime(ts);
        video.setVState(1);
        int res = videoService.addVideo(video);
        if (res ==0) { return new JsonResult<>(400,"添加失败");}
            return new JsonResult<>(200,video);//
    }

//    @RequestMapping(value = "/listValue",method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResult<Object> listValue(@)
}

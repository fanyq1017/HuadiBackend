package com.example.huadibackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Video;
import com.example.huadibackend.service.VideoService;
import com.example.huadibackend.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoContoller {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Object> addVideo(Video video) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        video.setVPublishtime(ts);
        video.setVState(1);
        int res = videoService.addVideo(video);
        if (res == 0) {
            return new JsonResult<>(400, "添加失败");
        }
        return new JsonResult<>(200, video);//
    }

    @RequestMapping(value = "/listValue", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<Object> listValue
            (@RequestParam(value = "vState") Integer vState) {
        List<Video> listPage = videoService.getVideoList(vState);
        return new JsonResult<>(200, listPage);
    }

    @RequestMapping(value = "/playVideo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<Object> playVideo(Integer vId) {
        Video video = videoService.PlayVideo(vId);
        if (video == null) {
            return new JsonResult<>(400, "视频ID出错");
        } else {
            int vState = video.getVState();
            if (vState == 0) {
                return new JsonResult<>(404, "视频已失效");
            }
            return new JsonResult<>(200, video);
        }
    }

    @RequestMapping(value = "/deleteVideo",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<String> deleteVideo(Integer vId) {
        int res = videoService.deleteVideo(vId);
        if (res == 0 ) { return new JsonResult<>(400,"删除失败");}
        else if (res ==1 ) {return new JsonResult<>(200,"删除成功");}
        else return new JsonResult<>(400,"项目异常");
    }

    @RequestMapping(value = "/amendVideo",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<String> amendVideoInfo(Video video) {
         int res = videoService.updateVideo(video);
         if (res ==0 ) return new JsonResult<String>(400,"更新失败");
         else return new JsonResult<String>(200,"更新成功");
    }

//    @RequestMapping(value = "/searchVideo",method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResult<Object> searchVideo()
}

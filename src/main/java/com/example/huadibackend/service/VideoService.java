package com.example.huadibackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.huadibackend.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> getVideoList(Integer vState);

    int deleteVideo(Integer vId);

    Video PlayVideo(Integer vId);

    int addVideo(Video video);

    int updateVideo (Video video);


}

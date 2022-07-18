package com.example.huadibackend.service.serviceimpl;

import com.example.huadibackend.entity.Video;
import com.example.huadibackend.mapper.VideoMapper;
import com.example.huadibackend.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper videoMapper;
    @Override
    public List<Video> getVideoList(Integer vState) {
        Map<String, Object> map =new HashMap<>();
        map.put("v_state",vState);
        return videoMapper.selectByMap(map);
    }

    @Override
    public int deleteVideo(Integer vId) {
        return videoMapper.deleteById(vId);
    }

    @Override
    public Video PlayVideo(Integer vId) {
        return videoMapper.selectById(vId);
    }

    @Override
    public int addVideo(Video video) {
        return videoMapper.insert(video);
    }

    @Override
    public int updateVideo(Video video) {
        return videoMapper.updateById(video);
    }
}

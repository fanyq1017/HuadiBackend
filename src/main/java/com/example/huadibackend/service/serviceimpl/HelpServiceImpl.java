package com.example.huadibackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Help;
import com.example.huadibackend.mapper.HelpMapper;
import com.example.huadibackend.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpServiceImpl implements HelpService {
    @Autowired
    HelpMapper helpMapper;
    @Override
    public IPage<Help> viewHelpByType(Page<Help> page, Integer hType) {

            QueryWrapper<Help> qw=new QueryWrapper<>();
            qw.eq("h_type",hType);
            return helpMapper.selectPage(page,qw);

        }

    @Override
    public int insert(Help help) {
        return helpMapper.insert(help);
    }

    @Override
    public int updateInfo(Help help) {
        return helpMapper.updateById(help);
    }


    @Override
    public int assist(Integer hId, String hHelper, String hHelpedtel) {
        UpdateWrapper<Help> uw = new UpdateWrapper<>();
        uw.set("h_helper",hHelper);
        uw.set("h_helpertel",hHelpedtel);
        uw.eq("h_Id",hId);
        return helpMapper.update(null,uw);
    }

    @Override
    public Help viewById(Integer hId) {
        return helpMapper.selectById(hId);
    }




}

package com.example.huadibackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Help;
import com.example.huadibackend.service.HelpService;
import com.example.huadibackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/help")
public class HelpContorller {
    @Autowired
    HelpService helpService;

    @RequestMapping(value = "/addHelp", method = RequestMethod.POST)
    public JsonResult<Object> add(Help help) {
        help.setHType(0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            helpService.insert(help);
            help.setHPublishdate(timestamp);
            int res = helpService.updateInfo(help);
            if (res == 1) {
                return new JsonResult<>(200, help);
            } else {
                return new JsonResult<>(200, "添加失败");
            }
        } catch (Exception e) {
            return new JsonResult<>(400, "请填写完善信息");
        }
    }

    @RequestMapping(value = "/viewNeed", method = RequestMethod.GET)
    public JsonResult<Object> viewNeed(@RequestParam(value = "page")Integer current,@RequestParam(value = "count")Integer size, @RequestParam(value = "hType")Integer hType){
        Page<Help> page =new Page<>(current,size);
        IPage<Help> ipage= helpService.viewHelpByType(page,hType);
        return new JsonResult<>(200,ipage);
    }

//    @RequestMapping(value = "/amendInfo",method = RequestMethod.POST)
//    public JsonResult<String> amendInfo(){;}

    @RequestMapping(value = "/assist",method = RequestMethod.POST)
    public JsonResult<String> assist(Integer hId,String hHelper,String hHelpertel){
         Help help =helpService.viewById(hId);
         help.setHHelper(hHelper);
         help.setHHelpertel(hHelpertel);
         help.setHType(1);

         int res =helpService.updateInfo(help);
         if (res ==1 ) {
             return new JsonResult<>(200, "帮扶成功");
         }else return new JsonResult<>(400,"信息更新失败");
    }

    @RequestMapping(value = "/searchNeed",method = RequestMethod.POST)
    public JsonResult<Object> searchNeed(@RequestParam(value = "page")Integer current,
                                         @RequestParam(value = "count")Integer size,
                                         @RequestParam(value = "hName") String hName){
        Page<Help> page =new Page<>(current,size);
        IPage<Help> iPage = helpService.searchNeed(page,hName);
        return new JsonResult<>(200,iPage);
    }

}

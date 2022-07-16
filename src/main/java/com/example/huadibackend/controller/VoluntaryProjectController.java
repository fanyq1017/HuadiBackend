package com.example.huadibackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryProject;
import com.example.huadibackend.service.VoluntaryProjectService;
import com.example.huadibackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/project")
public class VoluntaryProjectController {
    @Autowired
    VoluntaryProjectService voluntaryProjectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult<String> add(VoluntaryProject voluntaryProject) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (voluntaryProject.getPId() == -1) {
            voluntaryProject.setPPublishdate(timestamp);
        } else {voluntaryProject.setPEdittime(timestamp);}
            int res = voluntaryProjectService.addProject(voluntaryProject);
            if (res == 1) {
                return new JsonResult<String>(200, "添加成功");
            } else {
                return new JsonResult<String>(400, "添加失败");
            }
        }


        @RequestMapping(value= "/query" ,method = RequestMethod.GET) //通过省市区找项目
        public JsonResult<IPage<VoluntaryProject>> query(@RequestParam(value = "page")Integer current,
                                        @RequestParam(value = "size")Integer size,
                                        @RequestParam(value ="provinceRegionCode")Integer procinceRegioncode,
                                        @RequestParam(value ="cityRegionCode")Integer cityRegioncode,
                                        @RequestParam(value ="districtRegionCode")Integer districtRegioncode){
                Page<VoluntaryProject> page = new Page<>(current, size);
                IPage ipage = voluntaryProjectService.selectPageByRegioncode(page,procinceRegioncode,cityRegioncode,districtRegioncode);
                return new JsonResult<IPage<VoluntaryProject>>(200,ipage);
        }
}

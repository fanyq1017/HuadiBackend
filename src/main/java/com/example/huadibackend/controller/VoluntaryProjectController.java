package com.example.huadibackend.controller;

import com.example.huadibackend.entity.VoluntaryProject;
import com.example.huadibackend.service.VoluntaryProjectService;
import com.example.huadibackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class VoluntaryProjectController {
    @Autowired
    VoluntaryProjectService voluntaryProjectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult<String> add(VoluntaryProject voluntaryProject) {
        int res = voluntaryProjectService.addProject(voluntaryProject);
        if (res == 1) {
            return new JsonResult<String>(200, "添加成功");
        } else {
            return new JsonResult<String>(400, "添加失败");
        }
    }


}
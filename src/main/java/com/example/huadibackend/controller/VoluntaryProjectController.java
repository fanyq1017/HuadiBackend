package com.example.huadibackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.User;
import com.example.huadibackend.entity.VoluntaryProject;
import com.example.huadibackend.service.VoluntaryProjectService;
import com.example.huadibackend.util.JsonResult;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/project")
public class VoluntaryProjectController {
    @Autowired
    VoluntaryProjectService voluntaryProjectService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult<String> add(Integer pId,String pImage,String pName,Integer pType,String pLocation,String pProjectstart,
                                  String pProjectend,String pRecruitstart,String pRecruitend,
                                  String pServeclient,String pInfo,String pPeople,String pTelephone,Integer pProvinceregioncode,Integer pCityregioncode,
                                  Integer pDistrictregioncode) {
            System.out.println(pProjectstart);
            pProjectstart += " 08:00:00";
            pProjectend += " 08:00:00";
            pRecruitend += " 08:00:00";
            pRecruitstart += " 08:00:00";

        System.out.println(pProjectstart+" \n"+pProjectend+" \n"+pRecruitstart+" \n"+pRecruitend);
        Timestamp tspstart = Timestamp.valueOf(pProjectstart);
        Timestamp tspend = Timestamp.valueOf(pProjectend);
        Timestamp tsrstart = Timestamp.valueOf(pRecruitstart);
        Timestamp tsrend = Timestamp.valueOf(pRecruitend);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            VoluntaryProject voluntaryProject =new VoluntaryProject(pId,pImage,pName,pType,pLocation,tspstart,tspend,null,null,tsrstart,tsrend,
                    pServeclient,pInfo,pPeople,pTelephone,pProvinceregioncode,pCityregioncode,pDistrictregioncode);

        if (voluntaryProject.getPId() == -1) {
            voluntaryProject.setPPublishdate(timestamp);
            voluntaryProject.setPEdittime(timestamp);
        } else {voluntaryProject.setPEdittime(timestamp);}
            System.out.println(voluntaryProject);
            int res = voluntaryProjectService.addProject(voluntaryProject);
            if (res == 1) {
                return new JsonResult<String>(200, "????????????");
            } else {
                return new JsonResult<String>(400, "????????????");
            }
        }

        @ResponseBody
        @RequestMapping(value= "/query" ,method = RequestMethod.GET) //????????????????????????
        public JsonResult<IPage<VoluntaryProject>> query(@RequestParam(value = "page")Integer current,
                                        @RequestParam(value = "count")Integer size,
                                        @RequestParam(value ="provinceRegionCode")Integer procinceRegioncode,
                                        @RequestParam(value ="cityRegionCode")Integer cityRegioncode,
                                        @RequestParam(value ="districtRegionCode")Integer districtRegioncode){
                Page<VoluntaryProject> page = new Page<>(current, size);
                IPage ipage = voluntaryProjectService.selectPageByRegioncode(page,procinceRegioncode,cityRegioncode,districtRegioncode);
                return new JsonResult<IPage<VoluntaryProject>>(200,ipage);
        }

        @ResponseBody
        @RequestMapping(value = "/delete",method = RequestMethod.POST)
        public JsonResult<String> delete(@RequestParam(value = "pIds")Integer[] pIds){
            System.out.println(pIds);
            System.out.println(pIds.length);
        int cnt =0 ;
            for (Integer pId:pIds) {
                int res = voluntaryProjectService.deleteById(pId);
                if (res == 1) cnt++;
            } if (cnt == pIds.length) {
                return new JsonResult<>(200, "????????????");
            }
            else { return new JsonResult<>(400,"????????????");}
        }

        @ResponseBody
        @RequestMapping(value = "/update",method =RequestMethod.POST)
        public JsonResult<String> update(Integer pId,String pImage,String pName,Integer pType,String pLocation,String pProjectstart,
                                         String pProjectend,String pRecruitstart,String pRecruitend,
                                         String pServeclient,String pInfo,String pPeople,String pTelephone,Integer pProvinceregioncode,Integer pCityregioncode,
                                         Integer pDistrictregioncode) {
            pProjectstart += " 08:00:00";
            pProjectend += " 08:00:00";
            pRecruitend += " 08:00:00";
            pRecruitstart += " 08:00:00";
            //????????????
            System.out.println(pProjectstart+" \n"+pProjectend+" \n"+pRecruitstart+" \n"+pRecruitend);
            Timestamp tspstart = Timestamp.valueOf(pProjectstart);
            Timestamp tspend = Timestamp.valueOf(pProjectend);
            Timestamp tsrstart = Timestamp.valueOf(pRecruitstart);
            Timestamp tsrend = Timestamp.valueOf(pRecruitend);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            VoluntaryProject voluntaryProject =voluntaryProjectService.selectById(pId);
            System.out.println(voluntaryProject);
            Timestamp publishdate = voluntaryProject.getPPublishdate();

            VoluntaryProject newvoluntaryProject =new VoluntaryProject(pId,pImage,pName,pType,pLocation,tspstart,tspend,publishdate,timestamp,tsrstart,tsrend,
                    pServeclient,pInfo,pPeople,pTelephone,pProvinceregioncode,pCityregioncode,pDistrictregioncode);
            System.out.println(newvoluntaryProject);

            int res = voluntaryProjectService.updateById(newvoluntaryProject);
            if (res ==1 ) {return new JsonResult<>(200,"????????????");}
            else {return new JsonResult<>(400,"????????????");
        }
}
        @ResponseBody
        @RequestMapping(value = "/queryProject",method = RequestMethod.GET)
        public JsonResult<Object> queryProject(Integer pId){
                VoluntaryProject voluntaryProject =voluntaryProjectService.selectById(pId);
                if(voluntaryProject == null ) {return new JsonResult<>(400,"??????????????????");}
                return new JsonResult<>(200,voluntaryProject);
        }

        @ResponseBody
        @RequestMapping(value= "/queryAll" ,method = RequestMethod.GET) //????????????????????????
        public JsonResult<IPage<VoluntaryProject>> query(@RequestParam(value = "page")Integer current,
                                                         @RequestParam(value = "count")Integer size
                                                         ){
            Page<VoluntaryProject> page = new Page<>(current, size);
            IPage ipage = voluntaryProjectService.selectPage(page);
            return new JsonResult<IPage<VoluntaryProject>>(200,ipage);
        }

        @ResponseBody
        @RequestMapping(value = "/searchProject",method = RequestMethod.POST)//????????????????????????
        public JsonResult<Object> searchProject(@RequestParam(value = "page")Integer current,
                                                @RequestParam(value = "count")Integer size,
                                                @RequestParam(value = "pName") String pName){
            Page<VoluntaryProject> page =new Page<>(current,size);
            IPage<VoluntaryProject> iPage =voluntaryProjectService.searchByName(page,pName);
            return new JsonResult<>(200,iPage);
        }
}

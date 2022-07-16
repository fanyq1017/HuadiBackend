package com.example.huadibackend.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.VoluntaryAttribute;
import com.example.huadibackend.entity.VoluntaryProject;
import com.example.huadibackend.service.VoluntaryAttributeService;
import com.example.huadibackend.service.VoluntaryProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class VoluntaryActivityTests {
    @Autowired
    VoluntaryProjectService voluntaryProjectService;
    @Autowired
    VoluntaryAttributeService voluntaryAttributeService;
    @Test
    public void add () {
        VoluntaryAttribute voluntaryAttribute =new VoluntaryAttribute(null,1,1,1,1,1,1,1);
        VoluntaryAttribute voluntaryAttribute1 =new VoluntaryAttribute(null,1,2,1,3,1,2,1);
        VoluntaryAttribute voluntaryAttribute2 =new VoluntaryAttribute(null,2,3,2,3,1,2,1);

        voluntaryAttributeService.insert(voluntaryAttribute);
        voluntaryAttributeService.insert(voluntaryAttribute1);
        voluntaryAttributeService.insert(voluntaryAttribute2);

        System.out.println(voluntaryAttribute.toString());
        System.out.println(voluntaryAttribute1.toString());
        System.out.println(voluntaryAttribute2.toString());
    }

    @Test
    public void addProject() {
        Timestamp timestamp =new Timestamp(System.currentTimeMillis());
        VoluntaryProject voluntaryProject =new VoluntaryProject(null,"project1","1",1,"1",timestamp,timestamp,timestamp,timestamp,timestamp,timestamp,"1","1","before update.","a",1,1,1);
        voluntaryProjectService.addProject(voluntaryProject);
    }

    @Test
    public void find() {
        System.out.println(voluntaryProjectService.selectById(1));
    }

//    @Test
//    public void findbyAttr(){
//        Timestamp timestamp =new Timestamp(System.currentTimeMillis());
//        VoluntaryProject voluntaryProject =new VoluntaryProject(null,"1","project1","1",1,timestamp,timestamp,timestamp,timestamp,timestamp,"1","before update.","a",1,1,1);
//        Page<VoluntaryProject> page =new Page<>(1,5);
//        IPage<VoluntaryProject> ipage = voluntaryAttributeService.findByAttribute(page, voluntaryAttribute);
//        List<VoluntaryProject> res = ipage.getRecords();
//        System.out.println(res);
//    }

    @Test
    public void updateById(){
        Timestamp timestamp =new Timestamp(System.currentTimeMillis());
        VoluntaryProject voluntaryProject =new VoluntaryProject(null,"project1","1",1,"1",timestamp,timestamp,timestamp,timestamp,timestamp,timestamp,"1","1","before update.","a",1,1,1);
        System.out.println(voluntaryProjectService.selectById(voluntaryProject.getPId()));
        voluntaryProjectService.updateById(voluntaryProject);
        System.out.println(voluntaryProjectService.selectById(voluntaryProject.getPId()));
    }


}

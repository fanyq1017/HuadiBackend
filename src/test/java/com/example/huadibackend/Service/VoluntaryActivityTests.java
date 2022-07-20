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
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String pProjectstart="2022-07-11 00:00:00" ;
        Timestamp tspstart = Timestamp.valueOf(pProjectstart);
        String pProjectend="2022-08-01 00:00:00" ;
        Timestamp tspend = Timestamp.valueOf(pProjectend);
        String pRecruitend="2022-07-01 00:00:00";
        Timestamp tsrstart = Timestamp.valueOf(pRecruitend);
        String pRecruitstart="2022-09-02 00:00:00";
        Timestamp tsrend = Timestamp.valueOf(pRecruitstart);
//        VoluntaryProject voluntaryProject =voluntaryProjectService.selectById(pId);
        VoluntaryProject vp =new VoluntaryProject(2, "https://zwxt.mca.gov.cn/tyccyy_int/ucm/ucmAction!getFile.do?sysid=jmgc_nvsi&addrcode=6200&loginid=9&fileid=38609126453a4d52ab443b6e80a24fa9&accesskey=4Nhsx5Z7tOAmslkx7JtvJHJBokvJqCRtw9nbjHADA4&busitype=FILE&realid=528f119f8df5403eb0dd7fa0625a836d&crosscity=0&fromprovince=0", "疫情防控", 1, "遂宁市船山区凯丽滨江-一期", tspstart,tspend,timestamp,timestamp, tsrstart, tsrend, "城镇居民,其他", "在辖区开展疫情防控，排查风险区返遂人员", "章立春", "17720783866", 510000, 510900, 510903);
        System.out.println(voluntaryProjectService.selectById(vp.getPId()));
        System.out.println(vp);
        voluntaryProjectService.updateById(vp);
        System.out.println(voluntaryProjectService.selectById(vp.getPId()));
    }

    @Test
    public void str2Timestamp(){
         String time1 = "2022-10-04";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String time = df.format(new Date());

        System.out.println(Timestamp.valueOf(time));
    }


}

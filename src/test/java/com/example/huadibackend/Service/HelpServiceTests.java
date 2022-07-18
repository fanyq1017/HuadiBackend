package com.example.huadibackend.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Help;
import com.example.huadibackend.service.HelpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class HelpServiceTests {
    @Autowired
    HelpService helpService;

    @Test
    public void add() {
        Timestamp ts =new Timestamp(System.currentTimeMillis());
        Help help =new Help(null,"c","17720783866","15516133441",ts,"李四",1,0,"11111");
        helpService.insert(help);
        System.out.println(help);
    }

    @Test
    public void view(){
        Page<Help> page =new Page<>(1,10);
        IPage<Help> iPage = helpService.viewHelpByType(page,1);
        List<Help> list =iPage.getRecords();
        System.out.println(list);

        }

    }


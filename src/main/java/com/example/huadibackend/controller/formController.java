package com.example.huadibackend.controller;

import com.example.huadibackend.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class formController {

    @GetMapping("/form_layouts")//上传文件的初步模型
    public String formLayouts(){
        return "form/form_layouts";
    }
    @RequestMapping("/upload")//这个还是需要继续改改
    public String upload(@RequestPart("file")MultipartFile file
    ) throws IOException {
        if (!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File(System.getProperty("user.dir")+originalFilename));//这个也是需要进一步的改改，需要根据不同的文件上传到不同的位置
        }
        return "main";
    }

    @ResponseBody
    @RequestMapping(value ="/article",method = RequestMethod.POST )
    public JsonResult<String> load(String content){
        System.out.println(content);
        System.out.println("successfully received");
        return new JsonResult<String>(200,"OK");
    }



    }



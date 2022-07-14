package com.example.huadibackend.controller;

import com.example.huadibackend.util.JsonResult;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;


@Controller
public class formController {
    private static final String baseurl = "http://10.132.50.43:8080";
    @GetMapping("/form_layouts")//上传文件的初步模型
    public String formLayouts(){
        return "form/form_layouts";
    }

    @ResponseBody
    @RequestMapping("/article/uploadimg")//这个还是需要继续改改
    public JsonResult<String> upload(@RequestPart("image")MultipartFile file
    ) throws IOException {
        String url = null;
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename()+"_"+;
            file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/img/" + originalFilename));
            url = baseurl + "/img/" + originalFilename;
            System.out.println(url);
        }
        return new JsonResult<>(200, url);
    }

    @ResponseBody
    @RequestMapping(value ="/article",method = RequestMethod.POST )
    public JsonResult<String> load(String content, HttpSession httpSession){
        System.out.println(content);
        System.out.println("successfully received");
        System.out.println(httpSession);
        return new JsonResult<>(200,"OK");
    }

    /**
     * 上传图片
     *
     * @return 返回值为图片的地址
     */
//    @ResponseBody
//    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
//    public RespBean uploadImg(HttpServletRequest req, MultipartFile image) {
//        StringBuffer url = new StringBuffer();
//        String filePath = "blogimg/" + sdf.format(new Date());
//        String imgFolderPath = req.getServletContext().getRealPath(filePath);
//        File imgFolder = new File(imgFolderPath);
//        if (!imgFolder.exists()) {
//            imgFolder.mkdirs();
//        }
//        url.append(req.getScheme())
//                .append("://")
//                .append(req.getServerName())
//                .append(":")
//                .append(req.getServerPort())
//                .append(req.getContextPath())
//                .append(filePath);
//        String imgName = UUID.randomUUID() + "_" + image.getOriginalFilename().replaceAll(" ", "");
//        try {
//            IOUtils.write(image.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
//            url.append("/").append(imgName);
//            return new RespBean("success", url.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new RespBean("error", "上传失败!");
//    }


    }



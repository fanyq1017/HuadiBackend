package com.example.huadibackend.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.config.BaseConfig;
import com.example.huadibackend.entity.Article;
import com.example.huadibackend.service.ArticleService;
import com.example.huadibackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Created by lkc on 2022/7/14.
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseConfig {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public JsonResult<String> addNewArticle(Article article) {
        System.out.println(article);
        int result = articleService.addNewArticle(article);
        System.out.println("runFail");
        if (result == 1) {
            System.out.println(article.getMdContent());
            return new JsonResult<String>(200, article.getId() + "");
        } else {
            return new JsonResult<String>(400, article.getState() == 0 ? "文章保存失败!" : "文章发表失败!");
        }
    }

    /**
     * 上传图片
     *
     * @return 返回值为图片的地址
     */
    @ResponseBody
    @RequestMapping("/article/uploadimg")//这个还是需要继续改改
    public JsonResult<String> upload(@RequestPart("image")MultipartFile file
    ) throws IOException {
        String url = null;
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String imgName = UUID.randomUUID() + "_" + file.getOriginalFilename().replaceAll(" ", "");
            file.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/img/" + imgName));
            url = baseurl + "/img/" + imgName;
            System.out.println(url);
        }
        return new JsonResult<>(200, url);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<IPage<Article>> getArticleByState(@RequestParam(value = "state", defaultValue = "-1")Integer state, @RequestParam(value = "page", defaultValue = "1") Integer current, @RequestParam(value = "count", defaultValue = "6")Integer size,@RequestParam(value = "type",defaultValue = "0")Integer type) {
        Page<Article> page = new Page<>(current,size);
      //  int totalCount = articleService.getArticleCountByState(state, 1);//test 这里的1L是用作测试用的 uid不一定要不要
        IPage<Article> articles = articleService.selectByStateType(state,page,type);
        return new JsonResult<>(200, articles);
    }

    @RequestMapping(value = "/query" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<Article> getArticleById(@RequestParam(value = "id")Integer id) {
        System.out.println(id);
        Article article = articleService.getArticleById(id);
        System.out.println(article);
        return new JsonResult<Article>(200,article) ;
    }

    @RequestMapping(value = "/dustbin", method = RequestMethod.POST)
    public JsonResult<String> updateArticleState(Integer[] aIds, Integer state) {
        state =2 ;
        int cnt =0;
        try {
        for (Integer aId:aIds) {
            if (articleService.updateArticleState(aId, state) == 1 )
                cnt ++ ;
             }
        if (cnt == aIds.length){
                return new JsonResult<String>(200, "修改成功!");
            }
        return new JsonResult<String>(400, "存在无效ID");
         }catch(Exception e) {
            return new JsonResult<String>(400, "修改异常!");
        }
    }

    @RequestMapping("/dataStatistics")
    public Map<String,Object> dataStatistics() {
        Map<String, Object> map = new HashMap<>();
        List<String> categories = articleService.getCategories();
        List<Integer> dataStatistics = articleService.getDataStatistics();
        map.put("categories", categories);
        map.put("ds", dataStatistics);
        return map;
    }
}

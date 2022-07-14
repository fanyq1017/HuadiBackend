package com.example.huadibackend.controller;


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

import static com.example.huadibackend.controller.formController.baseurl;

/**
 * Created by lkc on 2022/7/14.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

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
    public Map<String, Object> getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "6") Integer count,String keywords) {
        int totalCount = articleService.getArticleCountByState(state, 1L,keywords);//test 这里的1L是用作测试用的
        List<Article> articles = articleService.getArticleByState(state, page, count,keywords);
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("articles", articles);
        return map;
    }

    @RequestMapping(value = "/{aid}", method = RequestMethod.GET)
    public Article getArticleById(@PathVariable Long aid) {
        return articleService.getArticleById(aid);
    }

    @RequestMapping(value = "/dustbin", method = RequestMethod.PUT)
    public JsonResult<String> updateArticleState(Long[] aids, Integer state) {
        if (articleService.updateArticleState(aids, state) == aids.length) {
            return new JsonResult<String>(200, "删除成功!");
        }
        return new JsonResult<String>(400, "删除失败!");
    }

    @RequestMapping(value = "/restore", method = RequestMethod.PUT)
    public JsonResult<String> restoreArticle(Integer articleId) {
        if (articleService.restoreArticle(articleId) == 1) {
            return new JsonResult<String>(200, "还原成功!");
        }
        return new JsonResult<String>(400, "还原失败!");
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

package com.example.huadibackend.Service;

import com.example.huadibackend.entity.Activity;
import com.example.huadibackend.entity.Article;
import com.example.huadibackend.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void addArticle() {
        Article article = new Article();
        for(int i =1;i<10;i++) {
            article = new Article(-1, "this is title", i, null, null, "###  111111", "<h3><a id=\"111111_0\"></a>111111</h3>", 1, -1);
            articleService.addNewArticle(article);
               }
    }

    @Test
    public void getArticleById()
    {
        Article article1 = articleService.getArticleById(2);
        System.out.println(article1);
    }

    @Test
    public void deleteArticleById()
    {
        int[] aid =new int[]{1,2,3,4};
        System.out.println(Arrays.toString(aid));
        System.out.println(articleService.deleteArticleById(aid));
    }
}


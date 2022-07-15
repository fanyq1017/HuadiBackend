package com.example.huadibackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.huadibackend.entity.Article;
import com.example.huadibackend.mapper.ArticleMapper;
import com.example.huadibackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int addNewArticle(Article article) {
        if (article.getId() == -1) {
            //添加操作
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishDate(timestamp);
            }
            article.setEditTime(timestamp);
            //设置当前用户
            //article.setUid(1);
            System.out.println(article);
            int i = articleMapper.addNewArticle(article);

            return i;
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (article.getState() == 1) {
                //设置发表日期
                article.setPublishDate(timestamp);
            }
            //更新
            article.setEditTime(new Timestamp(System.currentTimeMillis()));
            int i = articleMapper.updateArticle(article);
            return i;
        }
    }

    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }

    private Date getCurrentTime() {
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return date;
    }

    @Override
    public List<Article> getArticleByState(Integer state, Integer page, Integer count, String keywords) {
        return null;
    }

    @Override
    public int getArticleCountByState(Integer state, int uid, String keywords) {
        return 0;
    }


    @Override
    public int updateArticleState(int[] aids, Integer state) {
        return articleMapper.updateArticleState(aids, state);
    }

    @Override
    public int restoreArticle(Integer articleId) {
        return 0;
    }

    @Override
    public Article getArticleById(int aid) {
        Article article = articleMapper.getArticleById(aid);
        System.out.println(aid);
        return article;
    }

    @Override
    public void pvStatisticsPerDay() {

    }

    @Override
    public List<Integer> getDataStatistics() {
        return null;
    }

    @Override
    public List<String> getCategories() {
        return null;
    }

    @Override
    public int deleteArticleById(int[] aid) {
        QueryWrapper<Article> qw = new QueryWrapper<>();
        Integer[] aids = intToInteger(aid);
        List<Integer> resultList= new ArrayList<>(Arrays.asList(aids));
        //    qw.orderByDesc("publishtime");
        qw.in("id",resultList);
        int result = articleMapper.deleteArticleById(qw);
        return result;
    }

    private Integer[] intToInteger(int[] ints) {
        int length = ints.length;
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++) {
            integers[i] = ints[i];
        }
        return integers;
    }
}
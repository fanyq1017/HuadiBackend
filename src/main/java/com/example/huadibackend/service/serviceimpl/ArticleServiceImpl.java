package com.example.huadibackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    public IPage<Article> selectByStateType(Integer state,Page<Article> page,Integer type){
        QueryWrapper<Article> qw = new QueryWrapper<>();
        qw.eq("state",state);
        qw.eq(type !=-1,"type",type);
        return articleMapper.selectPage(page,qw);
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


//    @Override
//    public IPage<Article> getArticleByState(Integer state, Page<Article> page) {
//        QueryWrapper<Article> qw = new QueryWrapper<>();
//        qw.eq("state",state);
//        return articleMapper.selectPage(page,qw);
//    }



    @Override
    public int updateArticleState(Integer aid, Integer state) {
        return articleMapper.updateArticleState(aid, state);
    }

    @Override
    public int restoreArticle(Integer articleId) {
        return 0;
    }

    @Override
    public Article getArticleById(Integer aid) {
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
    public IPage<Article> queryByTitle(Page<Article> page, String title) {
        QueryWrapper<Article> qw = new QueryWrapper<>();
        qw.like("title",title);
        return articleMapper.selectPage(page,qw);
    }

    @Override
    public int deleteArticleById(Integer[] aids) {
        QueryWrapper<Article> qw = new QueryWrapper<>();
        List<Integer> resultList= new ArrayList<>(Arrays.asList(aids));
        qw.in("id",resultList);
        return articleMapper.deleteArticleById(qw);

    }

    @Override
    public int amendArticle(Article article){
        UpdateWrapper<Article> uw =new UpdateWrapper<>();
        uw.set("title",article.getTitle());
        uw.set("type",article.getType());
        uw.set("md_content",article.getMdContent());
        uw.set("html_content",article.getHtmlContent());
        uw.set("edit_time",new Timestamp(System.currentTimeMillis()));
        uw.eq("id",article.getId());
        return articleMapper.update(null,uw);
    }


}

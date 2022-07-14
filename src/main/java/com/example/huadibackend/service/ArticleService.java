package com.example.huadibackend.service;


import com.example.huadibackend.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface ArticleService {

    public int addNewArticle(Article article);


    public List<Article> getArticleByState(Integer state, Integer page, Integer count, String keywords) ;

//    public List<Article> getArticleByStateByAdmin(Integer page, Integer count,String keywords) {
//        int start = (page - 1) * count;
//        return articleMapper.getArticleByStateByAdmin(start, count,keywords);
//    }

    public int getArticleCountByState(Integer state, Long uid,String keywords);

    public int updateArticleState(Long[] aids, Integer state);

    public int restoreArticle(Integer articleId);

    public Article getArticleById(int aid);

    public void pvStatisticsPerDay() ;

    /**
     * 获取最近七天的数据
     * @return
     */
    public List<Integer> getDataStatistics();

    List<String> getCategories();
}


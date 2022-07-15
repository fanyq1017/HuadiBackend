package com.example.huadibackend.service;


import com.example.huadibackend.entity.Article;

import java.util.List;



public interface ArticleService {

    int addNewArticle(Article article);


    List<Article> getArticleByState(Integer state, Integer page, Integer count, String keywords) ;

//    public List<Article> getArticleByStateByAdmin(Integer page, Integer count,String keywords) {
//        int start = (page - 1) * count;
//        return articleMapper.getArticleByStateByAdmin(start, count,keywords);
//    }

    int getArticleCountByState(Integer state, int uid, String keywords);

    int updateArticleState(int[] aids, Integer state);

    int deleteArticleById(int[] aid);

    int restoreArticle(Integer articleId);

    Article getArticleById(int aid);

    void pvStatisticsPerDay() ;

    /**
     * 获取最近七天的数据
     * @return
     */
    List<Integer> getDataStatistics();

    List<String> getCategories();
}


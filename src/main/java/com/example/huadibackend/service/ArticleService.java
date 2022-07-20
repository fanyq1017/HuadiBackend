package com.example.huadibackend.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Article;

import java.util.List;



public interface ArticleService {

    int addNewArticle(Article article);


//    public List<Article> getArticleByStateByAdmin(Integer page, Integer count,String keywords) {
//        int start = (page - 1) * count;
//        return articleMapper.getArticleByStateByAdmin(start, count,keywords);
//    }

    IPage<Article> selectByStateType(Integer state, Page<Article> page, Integer type);

    //int getArticleCountByState(Integer state, int uid, String keywords);

    int updateArticleState(Integer aid, Integer state);

    int deleteArticleById(Integer[] aids);

    int restoreArticle(Integer articleId);

    Article getArticleById(Integer aid);


    void pvStatisticsPerDay();

    /**
     * 获取最近七天的数据
     *
     * @return
     */
    List<Integer> getDataStatistics();

    List<String> getCategories();

    IPage<Article> queryByTitle(Page<Article> page,String title);

    int amendArticle(Article article);
}

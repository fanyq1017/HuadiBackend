package com.example.huadibackend.mapper;

import com.example.huadibackend.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sang on 2017/12/20.
 */

@Mapper
public interface ArticleMapper {
    @Options(useGeneratedKeys = true)
    @Insert("insert into article(title,u_id,publishdate,mdContent," +
            "state,edittime,type,htmlContent) values(#{title}," +
            " #{uid},#{publishDate},#{mdContent},#{state},#{editTime},#{type},#{htmlContent})")
    int addNewArticle(Article article);

    @Update("update article set (title=#{title},mdContent=#{mdContent},htmlContent=#{htmlContent},editTime=#{editTime}")
    int updateArticle(Article article);

    List<Article> getArticleByState(@Param("state") Integer state, @Param("start") Integer start, @Param("count") Integer count, @Param("uid") Long uid,@Param("keywords") String keywords);

//  List<Article> getArticleByStateByAdmin(@Param("start") int start, @Param("count") Integer count, @Param("keywords") String keywords);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") Long uid, @Param("keywords") String keywords);

    int updateArticleState(@Param("aids") Long aids[], @Param("state") Integer state);

    int updateArticleStateById(@Param("articleId") Integer articleId, @Param("state") Integer state);

    int deleteArticleById(@Param("aids") Long[] aids);

    @Select("select * from article where id = ${aid}")
    Article getArticleById(int aid);

    void pvIncrement(Long aid);

    //INSERT INTO pv(countDate,pv,uid) SELECT NOW(),SUM(pageView),uid FROM article GROUP BY uid
    void pvStatisticsPerDay();

    List<String> getCategories(Long uid);

    List<Integer> getDataStatistics(Long uid);
}

package com.example.huadibackend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.huadibackend.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sang on 2017/12/20.
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Options(useGeneratedKeys = true)
    @Insert("insert into article(title,u_id,publishdate,mdContent," +
            "state,edittime,type,htmlContent) values(#{title}," +
            " #{uid},#{publishDate},#{mdContent},#{state},#{editTime},#{type},#{htmlContent})")
    int addNewArticle(Article article);

    @Update("update article set title=#{title},mdContent=#{mdContent},htmlContent=#{htmlContent},editTime=#{editTime} where id =#{id}")
    int updateArticle(Article article);

    int getArticleCountByState(@Param("state") Integer state, @Param("uid") int uid, @Param("keywords") String keywords);

    int updateArticleState(@Param("aids") Integer aid, @Param("state") Integer state);

    int updateArticleStateById(@Param("articleId") Integer articleId, @Param("state") Integer state);

    @Delete("delete from article ${ew.customSqlSegment}")
    int deleteArticleById(@Param("ew") QueryWrapper<Article> qw);

    @Select("select * from article where id = #{aid}")
    Article getArticleById(int aid);
//
//    void pvIncrement(Long aid);
//
//    //INSERT INTO pv(countDate,pv,uid) SELECT NOW(),SUM(pageView),uid FROM article GROUP BY uid
//    void pvStatisticsPerDay();
//
//    List<String> getCategories(int uid);
//
//    List<Integer> getDataStatistics(int uid);
}

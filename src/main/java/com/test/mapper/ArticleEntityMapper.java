package com.test.mapper;

import com.test.entity.ArticleAndUserEntity;
import com.test.entity.ArticleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleEntityMapper {

    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleEntity record);

    int insertSelective(ArticleEntity record);

    ArticleEntity selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleEntity record);

    int updateByPrimaryKey(ArticleEntity record);

    List<ArticleAndUserEntity> selectByTime();

}
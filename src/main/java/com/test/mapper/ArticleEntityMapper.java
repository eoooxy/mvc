package com.test.mapper;

import com.test.entity.ArticleEntity;

public interface ArticleEntityMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleEntity record);

    int insertSelective(ArticleEntity record);

    ArticleEntity selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleEntity record);

    int updateByPrimaryKey(ArticleEntity record);
}
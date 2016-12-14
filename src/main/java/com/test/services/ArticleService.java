package com.test.services;

import com.test.entity.ArticleEntity;

import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */
public interface ArticleService {

    List<ArticleEntity> selectByTime();

    int insert(ArticleEntity entity);
}

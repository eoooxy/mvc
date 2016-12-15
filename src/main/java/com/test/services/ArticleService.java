package com.test.services;

import com.test.entity.ArticleAndUserEntity;
import com.test.entity.ArticleEntity;

import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */
public interface ArticleService {

    List<ArticleAndUserEntity> selectByTime();

    int insert(ArticleEntity entity);

    ArticleEntity selectById(Integer id);
}

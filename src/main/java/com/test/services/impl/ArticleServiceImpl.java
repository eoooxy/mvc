package com.test.services.impl;

import com.test.entity.ArticleAndUserEntity;
import com.test.entity.ArticleEntity;
import com.test.mapper.ArticleEntityMapper;
import com.test.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleEntityMapper articleEntityMapper;

    @Override
    public List<ArticleAndUserEntity> selectByTime() {
        return articleEntityMapper.selectByTime();
    }

    @Override
    public int insert(ArticleEntity entity) {
        return articleEntityMapper.insert(entity);
    }

    @Override
    public ArticleEntity selectById(Integer id) {
        return articleEntityMapper.selectByPrimaryKey(id);
    }
}

package com.test.canvert;

import com.test.dto.ArticleDto;
import com.test.entity.ArticleAndUserEntity;
import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */
public class ArticleCanvert {

    public static ArticleDto convertFromEntityNew(ArticleAndUserEntity entity) {
        ArticleDto dto = new ArticleDto();
        dto.setUserId(entity.getUserId());
        dto.setArticleContent(entity.getArticleContent());
        dto.setArticleId(entity.getArticleId());
        dto.setCreaterTime(entity.getCreaterTime());
        dto.setRemark(entity.getRemark());

        UserEntity userEntity = entity.getUserEntity();
        dto.setUserDto(UserCanvert.convertFromEntity(userEntity));

        return dto;
    }

    public static ArticleDto convertFromEntityNew(ArticleEntity entity) {
        ArticleDto dto = new ArticleDto();
        dto.setUserId(entity.getUserId());
        dto.setArticleContent(entity.getArticleContent());
        dto.setArticleId(entity.getArticleId());
        dto.setCreaterTime(entity.getCreaterTime());
        dto.setRemark(entity.getRemark());
        return dto;
    }

    public static List<ArticleDto> convertFromEntityNew(List<ArticleAndUserEntity> entities) {
        List<ArticleDto> dtos = new ArrayList<ArticleDto>();
        for (ArticleAndUserEntity entity : entities
                ) {
            dtos.add(convertFromEntityNew(entity));
        }
        return dtos;
    }

    public static ArticleAndUserEntity convertFromDto(ArticleDto dto) {
        ArticleAndUserEntity entity = new ArticleAndUserEntity();

        entity.setUserId(dto.getUserId());
        entity.setArticleContent(dto.getArticleContent());
        entity.setArticleId(dto.getArticleId());
        entity.setCreaterTime(dto.getCreaterTime());
        entity.setRemark(dto.getRemark());

        UserEntity userEntity = UserCanvert.canvertFromDto(dto.getUserDto());
        entity.setUserEntity(userEntity);

        return entity;

    }

    public static ArticleEntity convertFromDtoSingle(ArticleDto dto) {
        ArticleEntity entity = new ArticleEntity();

        entity.setUserId(dto.getUserId());
        entity.setArticleContent(dto.getArticleContent());
        entity.setArticleId(dto.getArticleId());
        entity.setCreaterTime(dto.getCreaterTime());
        entity.setRemark(dto.getRemark());
        return entity;

    }
}

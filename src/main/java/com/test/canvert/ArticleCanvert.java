package com.test.canvert;

import com.test.dto.ArticleDto;
import com.test.dto.UserDto;
import com.test.entity.ArticleEntity;
import com.test.entity.UserEntity;
import com.test.utils.BeanPropertiesCopy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xueyuan
 * @dater 2016-12-14 0014.
 */
public class ArticleCanvert {

    public static ArticleDto convertFromEntity(ArticleEntity entity) {
        ArticleDto dto = new ArticleDto();
        try {
            BeanPropertiesCopy.propertiesCopy(entity, dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public static List<ArticleDto> convertFromEntity(List<ArticleEntity> entities) {
        List<ArticleDto> dtos = new ArrayList<>();
        dtos.addAll(entities.stream().map(ArticleCanvert::convertFromEntity).collect(Collectors.toList()));
        return dtos;
    }

    public static ArticleDto convertFromEntityNew(ArticleEntity entity) {
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

    public static List<ArticleDto> convertFromEntityNew(List<ArticleEntity> entities) {
        List<ArticleDto> dtos = new ArrayList<ArticleDto>();
        for (ArticleEntity entity : entities
                ) {
            dtos.add(convertFromEntityNew(entity));
        }
        return dtos;
    }


}

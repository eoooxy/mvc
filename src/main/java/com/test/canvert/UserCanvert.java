package com.test.canvert;

import com.test.dto.UserDto;
import com.test.entity.UserEntity;
import com.test.utils.BeanPropertiesCopy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xueyuan
 * @dater 2016-11-24 0024.
 */
public class UserCanvert {

    public static UserDto convertFromEntity(UserEntity entity) {
        UserDto dto = new UserDto();
        try {
            BeanPropertiesCopy.propertiesCopy(entity, dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public static List<UserDto> convertFromEntity(List<UserEntity> entities) {
        List<UserDto> dtos = new ArrayList<>();
        dtos.addAll(entities.stream().map(UserCanvert::convertFromEntity).collect(Collectors.toList()));
        return dtos;
    }


    public static UserEntity canvertFromDto(UserDto dto) {

        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setUserAge(dto.getUserAge());
        entity.setUserSex(dto.getUserSex());
        entity.setPetName(dto.getPetName());
        entity.setUserName(dto.getUserName());
        entity.setUserPassword(dto.getUserPassword());
        return entity;

    }
}

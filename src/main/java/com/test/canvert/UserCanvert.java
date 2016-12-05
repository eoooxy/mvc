package com.test.canvert;

import com.test.dto.UserDto;
import com.test.entity.UserEntity;

/**
 * @author xueyuan
 * @dater 2016-11-24 0024.
 */
public class UserCanvert {
    public static UserEntity canvertFromEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setUserName(dto.getUserName());
        entity.setUserPwd(dto.getUserPwd());
        return entity;
    }
}

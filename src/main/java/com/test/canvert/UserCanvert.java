package com.test.canvert;

import com.test.dto.UserDto;
import com.test.entity.UserEntity1;

/**
 * @author xueyuan
 * @dater 2016-11-24 0024.
 */
public class UserCanvert {
    public static UserEntity1 canvertFromEntity(UserDto dto) {
        UserEntity1 entity = new UserEntity1();
        entity.setId(dto.getId());
        entity.setUserName(dto.getUserName());
        entity.setUserPwd(dto.getUserPwd());
        return entity;
    }
}

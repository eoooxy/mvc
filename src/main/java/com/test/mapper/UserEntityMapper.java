package com.test.mapper;

import com.test.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */

@Repository
public interface UserEntityMapper {

    UserEntity selectById(int id);

    UserEntity selectByEntity(UserEntity entity);

    int insertUser(UserEntity entity);
}

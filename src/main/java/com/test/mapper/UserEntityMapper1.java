package com.test.mapper;

import com.test.entity.UserEntity1;
import org.springframework.stereotype.Repository;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */

@Repository
public interface UserEntityMapper1 {

    UserEntity1 selectById(int id);

    UserEntity1 selectByEntity(UserEntity1 entity);

    int insertUser(UserEntity1 entity);
}

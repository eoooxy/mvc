package com.test.services;

import com.test.entity.UserEntity;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
public interface UserService {

    UserEntity isUser(UserEntity entity);

    int insert(UserEntity entity);

    int selectIdByNameAndPwd(String name, String password);

    int update(UserEntity entity);
}

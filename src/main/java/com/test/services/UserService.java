package com.test.services;

import com.test.entity.UserEntity1;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
public interface UserService {

    UserEntity1 isUser(UserEntity1 entity);

    int insert(UserEntity1 entity);

}

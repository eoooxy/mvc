package com.test.services.impl;

import com.test.entity.UserEntity1;
import com.test.mapper.UserEntityMapper1;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserEntityMapper1 userEntityMapper;

    public UserEntity1 isUser(UserEntity1 entity) {

        UserEntity1 resEntity;
        if (entity != null) {
            resEntity = userEntityMapper.selectByEntity(entity);
            if (resEntity != null) {
                return resEntity;
            }
        }
        return null;
    }

    public int insert(UserEntity1 entity) {
        return userEntityMapper.insertUser(entity);
    }
}

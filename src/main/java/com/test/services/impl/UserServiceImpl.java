package com.test.services.impl;

import com.test.entity.UserEntity;
import com.test.mapper.UserEntityMapper;
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
    UserEntityMapper userEntityMapper;

    public UserEntity isUser(UserEntity entity) {

        UserEntity resEntity;
        if (entity != null) {
            resEntity = userEntityMapper.selectByEntity(entity);
            if (resEntity != null) {
                return resEntity;
            }
        }
        return null;
    }
}

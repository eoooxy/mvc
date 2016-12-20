package com.test.services.impl;

import com.test.entity.UserEntity;
import com.test.mapper.UserEntityMapper;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserEntityMapper userEntityMapper;

    @Override
    public UserEntity isUser(UserEntity entity) {

        UserEntity resultEntity;
        if (entity != null) {
            resultEntity = userEntityMapper.selectByNameAndPwd(entity);
            if (resultEntity != null) {
                return resultEntity;
            }
        }
        return null;
    }

    @Override
    public int insert(UserEntity entity) {
        return userEntityMapper.insertSelective(entity);
    }

    @Override
    public int selectIdByNameAndPwd(String name, String password) {
        Map map = new HashMap<>();
        map.put("userName", name);
        map.put("userPassword", password);
        return userEntityMapper.selectIdByNameAndPwd(map);
    }

    @Override
    public int update(UserEntity entity) {

        if (entity != null) {
            return userEntityMapper.updateByUserNameSelective(entity);
        }
        return 0;
    }
}

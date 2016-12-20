package com.test.mapper;

import com.test.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKeyWithBLOBs(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    UserEntity selectByNameAndPwd(UserEntity entity);

    int selectIdByNameAndPwd(Map map);

    int updateByUserNameSelective(UserEntity entity);
}
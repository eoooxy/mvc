package com.test.mapper;

import com.test.entity.ChatEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatEntityMapper {
    int deleteByPrimaryKey(Integer chatId);

    int insert(ChatEntity record);

    int insertSelective(ChatEntity record);

    ChatEntity selectByPrimaryKey(Integer chatId);

    int updateByPrimaryKeySelective(ChatEntity record);

    int updateByPrimaryKey(ChatEntity record);
}
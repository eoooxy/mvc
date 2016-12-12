package com.test.mapper;

import com.test.entity.ChatListEntity;

public interface ChatListEntityMapper {
    int deleteByPrimaryKey(Integer chatId);

    int insert(ChatListEntity record);

    int insertSelective(ChatListEntity record);

    ChatListEntity selectByPrimaryKey(Integer chatId);

    int updateByPrimaryKeySelective(ChatListEntity record);

    int updateByPrimaryKey(ChatListEntity record);
}
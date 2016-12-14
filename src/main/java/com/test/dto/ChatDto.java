package com.test.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户详细信息
 *
 * @author xueyuan
 * @dater 2016-12-8 0008.
 */
public class ChatDto {

    private Integer chatId;

    private Integer fromUserId;

    private Integer toUserId;

    private String chatContent;

    private Date chatTime;

    private Integer typeId;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent == null ? null : chatContent.trim();
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }


    public static class Chat implements Serializable {
        public Integer chatId;

        public Integer fromUserId;

        public Integer toUserId;

        public String chatContent;

        public Date chatTime;

        public Integer typeId;

        public Integer getChatId() {
            return chatId;
        }

        public void setChatId(Integer chatId) {
            this.chatId = chatId;
        }

        public Integer getFromUserId() {
            return fromUserId;
        }

        public void setFromUserId(Integer fromUserId) {
            this.fromUserId = fromUserId;
        }

        public Integer getToUserId() {
            return toUserId;
        }

        public void setToUserId(Integer toUserId) {
            this.toUserId = toUserId;
        }

        public String getChatContent() {
            return chatContent;
        }

        public void setChatContent(String chatContent) {
            this.chatContent = chatContent == null ? null : chatContent.trim();
        }

        public Date getChatTime() {
            return chatTime;
        }

        public void setChatTime(Date chatTime) {
            this.chatTime = chatTime;
        }

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }
    }

}





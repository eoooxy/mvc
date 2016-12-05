package com.test.entity;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
public class UserEntity {

    private int id;
    private String userName;

    private String userPwd;

    public UserEntity() {

    }

    public UserEntity(int id, String userName, String userPwd) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}

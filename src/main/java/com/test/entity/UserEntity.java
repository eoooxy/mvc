package com.test.entity;

/**
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
public class UserEntity {

    private Integer id;
    private String userName;

    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

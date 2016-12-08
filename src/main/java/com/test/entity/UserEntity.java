package com.test.entity;

import java.io.Serializable;

/**
 * 帐号密码
 *
 * @author xueyuan
 * @dater 2016-11-23 0023.
 */
public class UserEntity implements Serializable {

    private int id;
    private String userName;
    private String userPwd;
    private UserDetailEntity userDetail;


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

    public UserDetailEntity getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailEntity userDetail) {
        this.userDetail = userDetail;
    }
}

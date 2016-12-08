package com.test.entity;

import java.io.Serializable;
import java.sql.Blob;

/**
 * 用户详细信息
 *
 * @author xueyuan
 * @dater 2016-12-8 0008.
 */
public class UserDetailEntity  implements Serializable {

    private int id;
    private String petName;
    private Blob headIcon;
    private String userSex;
    private String userAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Blob getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(Blob headIcon) {
        this.headIcon = headIcon;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
}

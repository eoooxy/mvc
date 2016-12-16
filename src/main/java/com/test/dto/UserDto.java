package com.test.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author xueyuan
 * @dater 2016-11-24 0024.
 */
public class UserDto  implements Serializable{

    private Integer userId;

    private String petName;

    private String userAge;

    private String userSex;

    private String userName;

    private String userPassword;

    private byte[] hardIcon;

    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge == null ? null : userAge.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public byte[] getHardIcon() {
        return hardIcon;
    }

    public void setHardIcon(byte[] hardIcon) {
        this.hardIcon = hardIcon;
    }


    public static class User implements Serializable {

        public Integer userId;

        public String petName;

        public String userAge;

        public String userSex;

        public String userName;

        public String userPassword;

        public byte[] hardIcon;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getPetName() {
            return petName;
        }

        public void setPetName(String petName) {
            this.petName = petName == null ? null : petName.trim();
        }

        public String getUserAge() {
            return userAge;
        }

        public void setUserAge(String userAge) {
            this.userAge = userAge == null ? null : userAge.trim();
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex == null ? null : userSex.trim();
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName == null ? null : userName.trim();
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword == null ? null : userPassword.trim();
        }

        public byte[] getHardIcon() {
            return hardIcon;
        }

        public void setHardIcon(byte[] hardIcon) {
            this.hardIcon = hardIcon;
        }
    }
}

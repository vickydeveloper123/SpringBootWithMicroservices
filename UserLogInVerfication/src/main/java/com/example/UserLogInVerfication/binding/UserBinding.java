package com.example.UserLogInVerfication.binding;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class UserBinding {

    private String UserName;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}

package com.example.UserLogInVerfication.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor

public class UserLogIn {



@Id
@GeneratedValue(strategy =
        GenerationType.IDENTITY)
    private Long id;

@Column(name="user_name")
    private String UserName;
@Column(name="password")
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    @Override
    public String toString() {
        return "UserLogIn{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}




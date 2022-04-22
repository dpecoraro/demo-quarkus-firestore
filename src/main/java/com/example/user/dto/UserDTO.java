package com.example.user.dto;

import java.util.Date;

public class UserDTO {

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String name;
    private String password;
    private Date birthday;
    private String email;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

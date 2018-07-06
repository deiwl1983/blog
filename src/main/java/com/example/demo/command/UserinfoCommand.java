package com.example.demo.command;

import java.util.Date;

public class UserinfoCommand  {

    private String name;
    private String nickname;
    private String password;
    private String cofirm;
    private Date newDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCofirm() {
        return cofirm;
    }

    public void setCofirm(String cofirm) {
        this.cofirm = cofirm;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }
}

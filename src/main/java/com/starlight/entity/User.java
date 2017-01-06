package com.starlight.entity;

/**
 * Created by thomas.wang on 2016/12/9.
 * <p>
 * 用户类
 */

public class User {
    private int id;
    private String account;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

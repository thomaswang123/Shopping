package com.starlight.entity;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/9.
 *
 * 用户类
 */
@Component
public class User {
private int   id ;
private String  account;
private String  password;

//多表查询使用(用户信息)
private UserInfo userInfo;

//管理员等级


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

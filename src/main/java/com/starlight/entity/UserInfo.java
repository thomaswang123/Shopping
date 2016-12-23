package com.starlight.entity;

/**
 * Created by thomas.wang on 2016/12/9.
 * 用信息类
 */
public class UserInfo {
private int id ;
private String sex ;
private String nickname ;
private int age ;
private String phone;
private String  address;

//用于多表查询
private User user ;

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getSex() {
    return sex;
}

public void setSex(String sex) {
    this.sex = sex;
}

public String getNickname() {
    return nickname;
}

public void setNickname(String nickname) {
    this.nickname = nickname;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}
}

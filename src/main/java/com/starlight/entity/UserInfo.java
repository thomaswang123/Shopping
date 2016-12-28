package com.starlight.entity;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/9.
 * 用信息类
 */
@Component
public class UserInfo {

    private int id;
    private String sex;
    private String nickname;
    private int age;
    private String phone;
    private String address;

    //用于多表查询
    private User user;
    //用于控制颜色
    private int color;
    //多表查询(管理员等级)
    private int classes;

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public int getColor() {

        return color;
    }


    public void setColor(int color) {

        this.color = color;
    }


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

package com.starlight.entity;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/23.
 */
@Component
public class Paging {
    private int rise;
    private int stop;

    //用来条件查询
    private float price ; //商品单价
    private UserInfo userInfo;
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    public int getRise() {
        return rise;
    }

    public void setRise(int rise) {
        this.rise = rise;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }
}

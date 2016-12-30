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
    //管理员级别
    private int classes;
    //用户账号的查询
    private String  name ;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

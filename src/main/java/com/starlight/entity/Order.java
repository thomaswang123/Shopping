package com.starlight.entity;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/9.
 *  订单类
 */
@Component
public class Order {
private int id;
private int userId;
private int goodsId;
private float money;
private int number;
private String date;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getUserId() {
    return userId;
}

public void setUserId(int userId) {
    this.userId = userId;
}

public int getGoodsId() {
    return goodsId;
}

public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
}

public float getMoney() {
    return money;
}

public void setMoney(float money) {
    this.money = money;
}

public int getNumber() {
    return number;
}

public void setNumber(int number) {
    this.number = number;
}

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}
}

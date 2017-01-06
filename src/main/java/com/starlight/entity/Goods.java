package com.starlight.entity;

/**
 * Created by thomas.wang on 2016/12/9.
 * 商品类
 */

public class Goods {
    //    商品ID
    private int id;
    //    商品名称
    private String name;
    //    价格
    private float price;
    //    描述
    private String describe;
    //    图片
    private String picture;
    private Repertory repertory;
    //分页查询用库存

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

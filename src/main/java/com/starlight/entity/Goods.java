package com.starlight.entity;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/9.
 *
 * 商品类
 */
@Component
public class Goods {
private int id ;
private String name ;
private float price ;
private String  describe ;
private String picture ;

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

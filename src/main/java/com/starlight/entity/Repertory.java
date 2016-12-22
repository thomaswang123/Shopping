package com.starlight.entity;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/16.
 * 库存类
 */
@Component
public class Repertory {
private int id ;
private int number;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getNumber() {
    return number;
}

public void setNumber(int number) {
    this.number = number;
}
}

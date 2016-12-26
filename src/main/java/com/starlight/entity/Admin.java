package com.starlight.entity;

/**
 * Created by thomas.wang on 2016/12/16.
 */

import org.springframework.stereotype.Component;

/**
 *  管理员类
 */
@Component
public class Admin {
private int id;
private int classes;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getClasses() {
    return classes;
}

public void setClasses(int classes) {
    this.classes = classes;
}
}

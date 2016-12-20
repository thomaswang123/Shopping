package com.starlight.entity;

/**
 * Created by thomas.wang on 2016/12/9.
 * 钱包类
 */
public class Wallet {
    private int w_id;
    private float w_money;
    private int w_pwd;

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public float getW_money() {
        return w_money;
    }

    public void setW_money(float w_money) {
        this.w_money = w_money;
    }

    public int getW_pwd() {
        return w_pwd;
    }

    public void setW_pwd(int w_pwd) {
        this.w_pwd = w_pwd;
    }
}

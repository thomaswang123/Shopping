package com.starlight.dao;

import com.starlight.entity.Wallet;

/**
 * Created by thomas.wang on 2016/12/21.
 * 用来进行对钱包的数据业务处理
 */

public interface IWalletDao {

    /**
     * 进行钱包支付密码修改
     * @param wallet  钱包类
     * @return  int
     */
    int alertPayPwdById(Wallet wallet);

    /**
     * 钱包注册
      * @param wallet
     */
    void register(Wallet wallet);

    /**
     * 查询钱包
     * @param id
     * @return
     */
    Wallet findById(int id);

    /**
     *  修改金额
     * @param wallet
     */
    void updateMoney(Wallet wallet);

    /**
     * 充值操作
     * @param momey
     */
    void rechargeMoney(float momey);

    /**
     * 修改密码
     * @param password
     */
    void changePWD(int password);
}

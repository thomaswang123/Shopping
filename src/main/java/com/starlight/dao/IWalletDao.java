package com.starlight.dao;

import com.starlight.entity.Wallet;

/**
 * Created by thomas.wang on 2016/12/21.
 * 用来进行对钱包的数据业务处理
 */

public interface IWalletDao {

    /**
     * 进行钱包支付密码修改
     * @param wallet  一条钱包信息
     * @return  int
     */
    int alertPayPwdById(Wallet wallet);

    /**
     * 钱包注册
      * @param wallet   一条钱包信息
     */
    void register(Wallet wallet);

    /**
     * 查询钱包
     * @param id    钱包用户id
     * @return  一条钱包信息
     */
    Wallet findById(int id);

    /**
     * 删除用户钱包数据
     * @param uid   用户id
     * @return  提示信息
     */
    int delWallet(int uid);

    /**
     *  修改金额
     * @param wallet
     */
    void updateMoney(Wallet wallet);

}

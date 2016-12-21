package com.starlight.dao;

import com.starlight.entity.Wallet;

/**
 * Created by thomas.wang on 2016/12/21.
 * 用来进行对钱包的数据业务处理
 */
public interface WalletDao {

    /**
     * 进行钱包支付密码修改
     * @param wallet  钱包类
     * @return  int
     */
    int alertPayPwdById(Wallet wallet);

}

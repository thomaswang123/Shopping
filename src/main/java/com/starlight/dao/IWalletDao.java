package com.starlight.dao;

import com.starlight.entity.Wallet;
import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/21.
 * 用来进行对钱包的数据业务处理
 */
@Component
public interface IWalletDao {

    /**
     * 进行钱包支付密码修改
     * @param wallet  钱包类
     * @return  int
     */
    int alertPayPwdById(Wallet wallet);

//	钱包注册
    void register(Wallet wallet);
//	查询钱包
    Wallet findWallet(int id);
//	充值操作
    void rechargeMoney(float momey);
//	修改密码
    void changePWD(int password);
}

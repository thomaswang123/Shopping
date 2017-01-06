package com.starlight.service;

import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 用户信息接口
 */
public interface IUserInfoService {


    /**
     * 统计数据的总数量
     * @return
     */
    int countUserIdNumber();


    /**
     * 通过用户id来查询用户信息
     *
     * @param id
     * @return
     */
     UserInfo findUserInfoById(int id);

    /**
     * 插入用户详细信息
     * @param userInfo
     */
    void register(UserInfo userInfo);

    /**
     * 钱包注册
     * @param wallet
     */

    void registerWallet(Wallet wallet);

    /**
     * 根据页面数据数量，以及第几页来展示数据
     * @param pagination
     * @param number
     * @return
     */
    List<UserInfo> pagination(String pagination,String number);

    /**
     * 修改昵称
     * @param userInfo
     */
    void updateNickName(UserInfo userInfo);

    /**
     * 修改年龄
     * @param userInfo
     */
    void updateUserAge(UserInfo userInfo);

    /**
     * 修改手机号
     * @param userInfo
     */
    void updateUserPhone(UserInfo userInfo);

    /**
     * 修改地址
     * @param userInfo
     */
    void updateUserAddress(UserInfo userInfo);
}

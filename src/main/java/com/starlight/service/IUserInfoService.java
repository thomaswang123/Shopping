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
     * 通过用户id查找用户信息（分页）
     * @param list
     * @return
     */
    List<UserInfo> findAllUserInfoById(List<Integer> list);

    /**
     * 通过姓名查询用户的信息
     *
     * @return Userinfo
     * @paramu info_nickname  用户姓名
     */
    List<UserInfo> findUserInfoByNickName(String uinfo_nickname);


    /**
     * 通过age查询用户的信息
     * @param age
     * @return
     */
     List<UserInfo> findUserInfoByAge(int age);

    /**
     * @param id
     * @return
     */
    boolean alterPhoneById(int id);

    /**
     * 通过用户id来查询用户信息
     *
     * @param u_id
     * @return
     */
     UserInfo findUserInfoById(int u_id);

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



}

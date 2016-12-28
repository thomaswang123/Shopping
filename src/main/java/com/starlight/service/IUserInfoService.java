package com.starlight.service;

import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 用户信息接口
 */
public interface IUserInfoService {

    /**
     * 查找用户信息（分页）
     * @param List<Integer> 用户id的集合
     * @return list<Userinfo><
     */
    List<UserInfo> byPagingfindAll(Paging paging);

    /**
     * 统计数据的总数量
     * @return
     */
    int countUserIdNumber();
    /**
     * 通过姓名查询用户的信息
     *
     * @return Userinfo
     * @paramu info_nickname  用户姓名
     */
    List<UserInfo> findUserInfoByNickName(String uinfo_nickname);


    /**
     * 通过age查询用户的信息
     *
     * @param age 用户年龄
     * @return Userinfo
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
     * @param id
     * @return
     */
     UserInfo findUserInfoById(int id);


    /**
     *
     */
    List<UserInfo> findAllUserInfoById(int id);

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

}

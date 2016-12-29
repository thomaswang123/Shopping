package com.starlight.dao;

import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */

public interface IUserInfoDao {
    /**
     * 通过用户id来查询用户信息
     * @param id 账号
     * @return list  集合
     */
     UserInfo findUserInfoById(int id);

/*    *//*
     * 查询详细信息
     * @param id
     * @return
     *//*
    UserInfo findById(int id);*/

    /**
     * 通过id寻找有关的用户信息
     * @param uid
     * @return
     */
     List<UserInfo> findAllUserInfoById(int uid);
    /**
     * 查找所有
     *
     * @return
     */
    List<UserInfo> byPagingfindAll(Paging paging);


    /**
     *  用户注册
     * @param userInfo
     */
    void register(UserInfo userInfo);



    /**
     * 修改昵称
     * @param nickName
     * @return
     */
    boolean alterNickName(String nickName);


    /**
     * 修改年龄
     * @param age
     * @return
     */
    boolean alterAge(int age);

    /**
     *修改电话
     * @param phone
     * @return
     */
    boolean alterPhone(String phone);

    /**
     * 修改地址
     * @param address
     * @return
     */
    boolean alterAddress(String address);

    /**
     * 删除改用户的数据
     * @param uid
     * @return
     */
     int delUserInfo(int uid);

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
     * 修改用户手机号
     * @param userInfo
     */
    void updateUserPhone(UserInfo userInfo);

    /**
     * 修改地址
     * @param userInfo
     */
    void updateUserAddress(UserInfo userInfo);
}

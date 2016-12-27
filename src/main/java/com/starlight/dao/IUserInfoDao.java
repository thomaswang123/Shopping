package com.starlight.dao;

import com.starlight.entity.UserInfo;

/**
 * Created by thomas.wang on 2016/12/19.
 */

public interface IUserInfoDao {
    /**
     * 通过用户id来查询用户信息
     * @param uinfo_id 账号
     * @return list  集合
     */
     UserInfo findUserInfoById(int uinfo_id);

    /**
     * 用户注册
     * @param userInfo
     */
      void register(UserInfo userInfo);

    /**
     * 查询详细信息
     * @param id
     * @return
     */
    UserInfo findAllById(int id);

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
     * 修改电话
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
}

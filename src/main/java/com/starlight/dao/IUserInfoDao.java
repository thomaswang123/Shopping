package com.starlight.dao;

import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 * 用户详细信息sql接口
 */

public interface IUserInfoDao {

    /**
     * 通过用户id来查询用户信息
     * @param id 账号
     * @return list  集合
     */
     UserInfo findUserInfoById(int id);

    /**
     * 查找用户详细信息
     * @param paging    分页
     * @return  用户详细信息集合
     */
    List<UserInfo> byPagingfindAll(Paging paging);

    /**
     *  用户注册
     * @param userInfo  一条用户详细信息
     */
    void register(UserInfo userInfo);

    /**
     * 修改昵称
     * @param userInfo  一条用户详细信息
     */
    void updateNickName(UserInfo userInfo);

    /**
     * 删除改用户的数据
     * @param uid   用户id
     * @return  提示信息
     */
     int delUserInfo(int uid);

    /**
     * 修改年龄
     * @param userInfo  一条用户详细信息
     */
    void updateUserAge(UserInfo userInfo);

    /**
     * 修改用户手机号
     * @param userInfo  一条用户详细信息
     */
    void updateUserPhone(UserInfo userInfo);

    /**
     * 修改地址
     * @param userInfo  一条用户详细信息
     */
    void updateUserAddress(UserInfo userInfo);
}

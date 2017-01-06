package com.starlight.service;

import com.starlight.entity.UserInfo;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 用户信息接口
 */
public interface IUserInfoService {


    /**
     * 获取数据库中用户数量
     * @return  用户量
     */
    int countUserIdNumber();


    /**
     * 查找用户信息
     * @param userId    用户id
     * @return  用户详细信息
     */
     UserInfo findUserInfoById(int userId);

    /**
     * 插入用户详细信息
     * @param userInfo  用户详细信息
     */
    void register(UserInfo userInfo);



    /**
     * 根据分页的页码来分页
     * @param pagination    页码
     * @param number  总数量
     * @return  用户信息集合
     */
    List<UserInfo> pagination(String pagination,String number);

    /**
     * 修改昵称
     * @param userInfo 用户信息
     */
    void updateNickName(UserInfo userInfo);

    /**
     * 修改年龄
     * @param userInfo  用户信息
     */
    void updateUserAge(UserInfo userInfo);

    /**
     * 修改手机号
     * @param userInfo  用户信息
     */
    void updateUserPhone(UserInfo userInfo);

    /**
     * 修改地址
     * @param userInfo  用户信息
     */
    void updateUserAddress(UserInfo userInfo);
}

package com.starlight.dao;

import com.starlight.entity.UserInfo;
import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Component
public interface IUserInfoDao {
    /**
     * 通过用户id来查询用户信息
     * @param uinfo_id 账号
     * @return list  集合
     */
     UserInfo findUserifoById(int uinfo_id);

//	  用户注册
      void register(UserInfo userInfo);
//	查询详细信息
UserInfo findAllById(int id);
//	修改昵称
boolean alterNickName(String nickName);
//	修改年龄
boolean alterAge(int age);
//	修改电话
boolean alterPhone(String phone);
//	修改地址
boolean alterAddress(String address);
}

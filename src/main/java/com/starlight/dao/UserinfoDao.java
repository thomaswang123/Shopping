package com.starlight.dao;

import com.starlight.entity.Userinfo;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
public interface UserinfoDao {
    /**
     * 通过用户id来查询用户信息
     * @param uinfo_id 账号
     * @return list  集合
     */
    public Userinfo findUserifoById(int uinfo_id);
}

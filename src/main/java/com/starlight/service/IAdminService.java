package com.starlight.service;

import com.starlight.entity.Admin;

/**
 * Created by thomas.wang on 2016/12/20.
 */
public interface IAdminService {
    /**
     * 返回用户的管理员的等级
     * @param u_id
     * @return
     */
     int finAllClssesById(int u_id);

    /**
     * 插入管理员信息
     * @param admin
     */
    void addAdmin(Admin admin);
}

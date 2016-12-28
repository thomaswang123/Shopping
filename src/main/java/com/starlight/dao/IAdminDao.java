package com.starlight.dao;

import com.starlight.entity.Admin;

/**
 * Created by thomas.wang on 2016/12/20.
 */

public interface IAdminDao {
    /**
     * 返回用户的管理员的等级
     * @param u_id
     * @return
     */
    int finAllClssesById(int u_id);

    /**
     * 添加管理员
     * @param admin
     */
    void addAdmin(Admin admin);
}

package com.starlight.dao;

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
}

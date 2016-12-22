package com.starlight.dao;

import org.springframework.stereotype.Component;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public interface IAdminDao {
    /**
     * 返回用户的管理员的等级
     * @param u_id
     * @return
     */
    int finAllClssesById(int u_id);
}

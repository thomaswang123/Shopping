package com.starlight.service;

/**
 * Created by thomas.wang on 2016/12/20.
 */
public interface IAdminService {
    /**
     * 返回用户的管理员的等级
     * @param u_id
     * @return
     */
     int findAllClssesById(int u_id);

    /**
     * 删除用户相关所有数据
     * @param uid
     * @return
     */
     int  delAllUserData(int uid);
}

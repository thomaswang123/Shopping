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
    int findAllClssesById(int u_id);

    /**
    * 查找用户有多少条数据
    * @return
    */
    int findAllCountNumber();
     
    
}

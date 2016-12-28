package com.starlight.dao;

import com.starlight.entity.Admin;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */

public interface IAdminDao {
    /**
     * 返回用户的管理员的等级
     * @param u_id
     * @return
     */
    List<Admin> finAllClassesById(int u_id);

    /**
     * 添加管理员
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 返回用户的管理员的等级
     * @param u_id
     * @return
     */
    int findClassesById(int u_id);

    /**
    * 查找用户有多少条数据
    * @return
    */
    int findAllCountNumber();

    /**
     * 统计管理员的数量
     * @return
     */
    int countAdminnumber();

    /**
     * 删除用户相关数据
     * @param uid
     * @return
     */
   int delAllUserData(int uid);


}

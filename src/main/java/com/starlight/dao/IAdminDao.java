package com.starlight.dao;

import com.starlight.entity.Admin;
import com.starlight.entity.Paging;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 管理员sql接口
 */

public interface IAdminDao {

    /**
     * 添加管理员
     * @param admin 管理员
     */
    void addAdmin(Admin admin);

    /**
     * 返回用户的管理员的等级
     * @param userId    用户id
     * @return  用户等级
     */
    int findClassesById(int userId);

    /**
     * 统计管理员的数量
     * @return  管理员数量
     */
    int countAdminnumber();

    /**
     * 删除用户相关数据
     * @param uid   用户id
     * @return  返回数据
     */
   int delAllUserData(int uid);

    /**
     * 修改admin
     * @param admin 管理员
     * @return  返回数据
     */
    int alterAdmin(Admin admin);

    /**
     * 查询级别等于classes的数据
     * @param paging    分页
     * @return  管理员集合
     */
    List<Admin> findByClasses(Paging paging);

    /**
     * 查询级别等于classes的数据总数量
     * @param paging    分页
     * @return  分页数据
     */
    int findSumNumberByClasses(Paging paging);
}

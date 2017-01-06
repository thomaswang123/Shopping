package com.starlight.service;

import com.starlight.entity.*;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */

public interface IAdminService {
    /**
     * 返回用户的管理员的等级
     *
     * @param u_id
     * @return
     */
    int findClassesById(int u_id);

    /**
     * 插入管理员信息
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 删除用户相关所有数据
     * @param uid
     * @return
     */
     int  delAllUserData(int uid);

    /**
     * 处理一夜所需要的商品数据
     * @param paging
     * @return
     */
     List<Goods> findAllByPaging(Paging paging);

    /**
     * 处理商品的总数量进行分页
     * @return
     */
    int conutGoodsDataNumber();

    /**
     * 根据页面数据数量，以及第几页来展示数据
     * @param pagination
     * @param number
     * @return
     */
    List<Goods> pagination(String pagination, String number);

    /**
     * 查询所有有关管理员的信息
     *
     * @return
     */
    List<UserInfo> findAdminByPaging(Paging paging);

    /**
     * 修改商品信息 和库存的信息
     * @param goods
     * @param repertory
     */
     int  alterGoodsData(Goods goods, Repertory repertory);

    /**
     * 删除商品信息
     * @param id
     * @return
     */
     int delGoodsData(int id);

    /**
     * 根据单价来查询
     * @param paging
     * @return
     */
    List<Goods>  findByGoodsPrice(Paging paging);

    /**
     * 修改admin的级别
     * @param admin
     * @param oneselfClasses
     * @return
     */
    String alterAdminClasses(Admin admin,int oneselfClasses,int classes);

    /**
     * 通过管理员的等级条件来查询
     * @param paging
     * @param classes
     * @return
     */
    List<UserInfo> findByAdminClasses(Paging paging,int classes);

    /**
     * 通过账号来模糊查询用户信息
     * @param paging
     * @return
     */
    List<UserInfo> findAllByLikeName(Paging paging);

    /**
     * 统计管理员的数量
     * @return
     */
    int countAdminnumber();

    /**
     * 查询级别等于classes的数据总数量
     * @param paging
     * @return
     */
    int findSumNumberByClasses(Paging paging);

}

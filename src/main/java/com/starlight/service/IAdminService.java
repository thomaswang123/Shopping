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
    List<Goods> pagination(String pagination,String number);
}

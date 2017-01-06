package com.starlight.service;

import com.starlight.entity.*;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 管理员业务
 */

public interface IAdminService {

    /**
     * 返回用户的管理员的等级
     * @param userId 用户
     * @return  返回用户等级
     */
    int findClassesById(int userId);

    /**
     * 添加管理员
     * @param admin 管理员
     */
    void addAdmin(Admin admin);

    /**
     * 删除用户所有数据的操作
     * @param userId 用户id
     * @return  如果操作成功返回非0
     */
     int  delAllUserData(int userId);

    /**
     * 查询商品
     * @param paging    分页
     * @return  商品集合
     */
     List<Goods> findAllByPaging(Paging paging);

    /**
     * 查询数据总数量
     * @return  返回商品总数
     */
    int conutGoodsDataNumber();

    /**
     * 根据分页的页码来展示数据
     * @param pagination    页码
     * @param number    总页数
     * @return  商品信息集合
     */
    List<Goods> pagination(String pagination, String number);

    /**
     * 查询有关管理员的信息
     * @param paging    分页
     * @return  如果操作成功返回非0
     */
    List<UserInfo> findAdminByPaging(Paging paging);

    /**
     * 修改商品信息和库存的信息
     * @param goods 商品
     * @param repertory 库存
     * @return  如果操作成功返回非0
     */
     int  alterGoodsData(Goods goods, Repertory repertory);

    /**
     * 删除商品信息
     * @param id    商品id
     * @return  如果操作成功返回非0
     */
     int delGoodsData(int id);

    /**
     * 根据单价来查询
     * @param paging    分页
     * @return  商品集合
     */
    List<Goods>  findByGoodsPrice(Paging paging);

    /**
     * 修改admin的级别也是间接添加管理员
     * @param admin     管理员
     * @param oneselfClasses    修改的等级
     * @param classes   现有等级
     * @return  提示信息
     */
    String alterAdminClasses(Admin admin,int oneselfClasses,int classes);

    /**
     * 通过管理员的等级条件来查询
     * @param paging    分页
     * @param classes   等级
     * @return  返回用户详细信息集合
     */
    List<UserInfo> findByAdminClasses(Paging paging,int classes);

    /**
     * 通过账号来模糊查询用户信息
     * @param paging    分页
     * @return  返回用户详细信息集合
     */
    List<UserInfo> findAllByLikeName(Paging paging);

    /**
     * 查找数据库里所有的管理员
     * @return  返回数据库中管理员的数量
     */
    int countAdminnumber();

    /**
     * 查询级别等于classes的数据总数量
     * @param paging    分页
     * @return  各等级的用户数量
     */
    int findSumNumberByClasses(Paging paging);

}

package com.starlight.dao;

import com.starlight.entity.Order;

import java.util.List;

import com.starlight.entity.Order;

/**
 * Created by james.jiang on 2016/12/21.
 */
public interface IOrderDao {

    /**
     * 添加订单
     * @param order
     */
    void addOrder(Order order);

    /**
     * 通过Id查找所有账单
     * @param id
     * @return
     */
    List<Order> findByUserId(int id);

    /**
     * 删除一条订单
     * @param id
     */
    void removeOrder(int id);

    /**
     * 删除用户订单
     * @param uid
     * @return
     */
    int delOrder(int uid);
}

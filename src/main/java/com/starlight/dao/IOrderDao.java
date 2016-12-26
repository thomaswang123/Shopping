package com.starlight.dao;

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
     * 删除用户订单
     * @param uid
     * @return
     */
    int delOrder(int uid);
}

package com.starlight.dao;

import com.starlight.entity.Order;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/21.
 * 订单sql接口
 */
public interface IOrderDao {

    /**
     * 添加订单
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 通过Id查找所有账单
     * @param id    用户id
     * @return  账单集合
     */
    List<Order> findByUserId(int id);

    /**
     * 删除一条订单
     * @param id    订单id
     */
    void removeOrder(int id);


}

package com.starlight.service;

import com.starlight.entity.Order;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/26.
 * 订单业务
 */
public interface IOrderService {

	/**
	 * 添加订单信息
	 * @param order		订单
	 */
	void addOrder(Order order);

	/**
	 * 通过用户id查找订单信息
	 * @param id	订单id
	 * @return	返回订单集合
	 */
	List<Order> findByUserId(int id);

	/**
	 * 删除订单信息
	 * @param id	订单id
	 */
	void removeOrder(int id);
}

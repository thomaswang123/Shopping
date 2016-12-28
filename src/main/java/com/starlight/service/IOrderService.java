package com.starlight.service;

import com.starlight.entity.Order;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/26.
 */
public interface IOrderService {
	/**
	 * 添加订单信息
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * 通过ID查找该用户的所有的订单
	 * @param id
	 * @return
	 */
	List<Order> findByUserId(int id);

	/**
	 * 删除一条数据
	 * @param id
	 */
	void removeOrder(int id);
}

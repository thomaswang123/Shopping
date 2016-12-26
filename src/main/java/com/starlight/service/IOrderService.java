package com.starlight.service;

import com.starlight.entity.Order;

/**
 * Created by james.jiang on 2016/12/26.
 */
public interface IOrderService {
	/**
	 * 添加订单信息
	 * @param order
	 */
	void addOrder(Order order);
}

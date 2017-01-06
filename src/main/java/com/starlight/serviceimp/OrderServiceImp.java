package com.starlight.serviceimp;

import com.starlight.dao.IOrderDao;
import com.starlight.entity.Order;
import com.starlight.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/26.
 *	订单业务实现类
 */
@Service
public class OrderServiceImp implements IOrderService {
	@Autowired
	private IOrderDao iOrderDao;
	@Transactional
	public void addOrder(Order order) {
		iOrderDao.addOrder(order);
	}
	@Transactional
	public List<Order> findByUserId(int id) {
		return iOrderDao.findByUserId(id);
	}
	@Transactional
	public void removeOrder(int id) {
		iOrderDao.removeOrder(id);
	}
}

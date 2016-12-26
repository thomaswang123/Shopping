package com.starlight.serviceimp;

import com.starlight.dao.IOrderDao;
import com.starlight.entity.Order;
import com.starlight.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by james.jiang on 2016/12/26.
 */
@Service
@Transactional
public class OrderServiceImp implements IOrderService {
	@Resource
	IOrderDao iOrderDao;
	public void addOrder(Order order) {
		iOrderDao.addOrder(order);
	}
}

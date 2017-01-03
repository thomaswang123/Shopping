package com.starlight.serviceimp;

import com.starlight.dao.IOrderDao;
import com.starlight.entity.Order;
import com.starlight.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/26.
 *	订单业务实现类
 */
@Service
@Transactional
public class OrderServiceImp implements IOrderService {
	@Resource
	private IOrderDao iOrderDao;

	public void addOrder(Order order) {
		iOrderDao.addOrder(order);
	}

	public List<Order> findByUserId(int id) {
		return iOrderDao.findByUserId(id);
	}

	public void removeOrder(int id) {
		iOrderDao.removeOrder(id);
	}
}

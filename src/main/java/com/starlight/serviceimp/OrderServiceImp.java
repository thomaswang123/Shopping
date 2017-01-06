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
public class OrderServiceImp implements IOrderService {

	/**订单sql接口*/
	@Resource
	private IOrderDao iOrderDao;

	/**
	 * 添加订单信息
	 * @param order		订单
	 */
	@Transactional
	public void addOrder(Order order) {
		iOrderDao.addOrder(order);
	}

	/**
	 * 通过用户id查找订单信息
	 * @param id	订单id
	 * @return	返回订单集合
	 */
	@Transactional
	public List<Order> findByUserId(int id) {
		return iOrderDao.findByUserId(id);
	}

	/**
	 * 删除订单信息
	 * @param id	订单id
	 */
	@Transactional
	public void removeOrder(int id) {
		iOrderDao.removeOrder(id);
	}
}

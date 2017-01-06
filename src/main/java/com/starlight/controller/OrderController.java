package com.starlight.controller;

import com.starlight.entity.Order;
import com.starlight.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/26.
 * 订单控制类
 */
@Controller
public class OrderController {

	/**用户订单业务*/
	@Resource
	private IOrderService iOrderService;

	/**
	 * 删除订单信息
	 * @param id	订单id
	 * @param httpSession	session
	 * @return	提示信息
	 */
	@RequestMapping(value = "/removeOrder.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String removeOrder(int id, HttpSession httpSession){
//		删除订单数据
		iOrderService.removeOrder(id);
//		删除session中的数据
		List<Order> list=(List<Order>) httpSession.getAttribute("orderList");
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
			}
		}
		httpSession.removeAttribute("orderList");
		httpSession.setAttribute("orderList",list);
		return "true";
	}

}

package com.starlight.controller;

import com.starlight.serviceimp.OrderServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by james.jiang on 2016/12/26.
 * 订单控制类
 */
@Controller
public class OrderController {
	@Resource
	private OrderServiceImp orderServiceImp;

	/**
	 * 删除订单信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeOrder.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String removeOrder(int id){
//		删除一条数据
		orderServiceImp.removeOrder(id);
		System.out.println("删除");
		return "true";
	}

}

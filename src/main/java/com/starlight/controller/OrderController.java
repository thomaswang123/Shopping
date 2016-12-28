package com.starlight.controller;

import com.starlight.serviceimp.OrderServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by james.jiang on 2016/12/26.
 */
@Controller
public class OrderController {
	@Resource
	OrderServiceImp orderServiceImp;

	@RequestMapping(value = "/removeOrder.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String removeOrder(int id,HttpSession httpSession){
//		删除一条数据
		orderServiceImp.removeOrder(id);
		System.out.println("删除");
		return "true";
	}

}

package com.starlight.controller;

import com.starlight.serviceimp.OrderServiceImp;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by james.jiang on 2016/12/26.
 */
@Controller
public class OrderController {
	@Resource
	OrderServiceImp orderServiceImp;

}

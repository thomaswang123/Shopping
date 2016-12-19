package com.starlight.controller;

import com.starlight.dao.UserDao;
import com.starlight.entity.UserEt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Controller
public class UserController {
/*    @Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}*/

@RequestMapping("login.do")
   public String test(){
		ApplicationContext act =
				/*new ClassPathXmlApplicationContext("*//*spring-mvc.xml");*/
		        new FileSystemXmlApplicationContext("");
		System.out.println(act);
		UserDao userdao = act.getBean(UserDao.class);
		System.out.println("进来了");
		List<UserEt> list = userdao.findAll();
		for (UserEt lists : list) {
			System.out.println(lists.getU_id() + "," + lists.getU_name() + "," + lists.getU_pawd());
		}
		return "index";
	}
}

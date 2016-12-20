package com.starlight.controller;

import com.starlight.dao.UserDao;
import com.starlight.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Controller
public class UserController {
    @RequestMapping("login.do")
    public String test(String username, String password) {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        System.out.println(act);
        UserDao userdao = act.getBean(UserDao.class);
        System.out.println("进来了");
        List<User> list = userdao.findAll();
        for (User lists : list) {
            System.out.println(lists.getU_id() + "," + lists.getU_name() + "," + lists.getU_pwd());
        }
        return "Index";
    }
}

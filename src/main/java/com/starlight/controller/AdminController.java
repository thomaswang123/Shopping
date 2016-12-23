package com.starlight.controller;

import com.starlight.entity.Paging;
import com.starlight.serviceimp.UserinfoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by thomas.wang on 2016/12/23.
 * 管理员
 */
@Controller
public class AdminController {
    @Resource
    UserinfoServiceImp userinfoServiceImp;

    //进入管理员界面
    @RequestMapping("adminOperation.do")
    public String adminInit(int number,int pagination, Paging paging, HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页
        paging.setRise((pagination*number)-number);
        paging.setStop(number*pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userdata", userinfoServiceImp.byPagingfindAll(paging));
        int numbersum = userinfoServiceImp.countUserIdNumber();
        if(number>numbersum){
            numbersum = 0;
        }else{
            numbersum = numbersum%number;
        }
        System.out.println(numbersum+","+number);
        rst.setAttribute("number",numbersum);
        rst.setAttribute("numbersum",userinfoServiceImp.countUserIdNumber());

        return "Admin";
    }
}

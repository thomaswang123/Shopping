package com.starlight.controller;

import com.starlight.entity.Paging;
import com.starlight.serviceimp.AdminServiceImp;
import com.starlight.serviceimp.UserinfoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Resource
    AdminServiceImp adminServiceImp;

    //进入管理员界面
    @RequestMapping("adminOperation.do")
    public String adminInit(int number, int pagination, Paging paging, HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userdata", userinfoServiceImp.byPagingfindAll(paging));
        //处理页数
        int numbersum = userinfoServiceImp.countUserIdNumber();
        if (number > numbersum) {
            numbersum = 0;
        } else {
            if (numbersum % number != 0) {
                numbersum = numbersum / number + 1;
            } else {
                numbersum = numbersum / number;
            }
            System.out.println(numbersum);
        }
        //吧数据发送到当前页面展示
        rst.setAttribute("number", numbersum);
        rst.setAttribute("numbersum", userinfoServiceImp.countUserIdNumber());
        return "admin";
    }

    //进行相关页码的数据的展示
    @RequestMapping("pagination.do")
    @ResponseBody
    public String pagination(String pagination, String number, HttpSession sessionPaging) {
        System.out.println("页码" + pagination);
        System.out.println(number);
     /*    sessionPaging.invalidate();*/
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userdata", userinfoServiceImp.pagination(pagination, number));
        return "yes";
    }

    //删除相对应的用户数据
    @RequestMapping("deluser.do")
    @ResponseBody
    public String deluser(String uid) {
        System.out.println(uid);
        if (adminServiceImp.delAllUserData(Integer.parseInt(uid))!=0){
            return "删除成功！";
        }
        return "可能还有数据存在，删除不了";
    }
}

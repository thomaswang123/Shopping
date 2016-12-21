package com.starlight.controller;

import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.serviceimp.Change_PasswordServiceImp;
import com.starlight.serviceimp.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Controller
public class Change_PasswordCotroller {
    //用来记录改用户id方便其他操作
    private int u_id = 0;
    //获取对用户业务进行处理的对象
    @Resource
    private UserServiceImp userServiceImp;

    //获取对密保以及密码问题处理的对象
    @Resource
    private Change_PasswordServiceImp change_PasswordServiceImp;

    public Change_PasswordServiceImp getChange_PasswordServiceImp() {
        return change_PasswordServiceImp;
    }

    public void setChange_PasswordServiceImp(Change_PasswordServiceImp change_PasswordServiceImp) {
        this.change_PasswordServiceImp = change_PasswordServiceImp;
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    //进行判断密保问题域答案是否一致，进行下一步的修改密码操作等
    @RequestMapping("answer.do")
    @ResponseBody
    public String consistency_OfJudgment(String[] result) {
        System.out.println("aaaa");
        //进行判断答案是否正确
        // 返回的是ajax的数据，不是页面的名字
        return change_PasswordServiceImp.Answer_Comparison(u_id, result);
    }


    //用来判断申请账号是否存在
    @RequestMapping("user_checkexist")
    //此注解不能省略 否则ajax无法接受返回值
    @ResponseBody
    public String user_CheckExist(String username) {
        //用户账号对应的id
        if ((u_id = userServiceImp.byname_GainId(username)) != 0) {
            //这里反回值是ajax的回调函数中数据！不是页面
            return change_PasswordServiceImp.findQuestionAndIddByUid(u_id);
        }
        return null;
    }

    //修改密码，支付密码，密保答案
    @RequestMapping("alertAll.do")
    //此注解不能省略 否则ajax无法接受返回值
    @ResponseBody
    public String alertAll(User user, String[] result, Wallet wallet, String password, String payment_code) {
        //用户的密码
        user.setU_id(u_id);
        user.setU_pwd(password);
        //用户的支付密码
       wallet.setW_id(u_id);
       wallet.setW_pwd(Integer.parseInt(payment_code));
 /*      System.out.println(ppid);*/
       //进行处理并返回结果
     /*   return  change_PasswordServiceImp.alertAllById(user, wallet, result);*/
        return "Aaa";
    }

    @RequestMapping("alertPpAll.do")
    @ResponseBody
    public String alertPpAll(String[] result,User user, String password, String payment_code,String[] ppid){
        System.out.println(result);
        return  "Aaa";
    }

}

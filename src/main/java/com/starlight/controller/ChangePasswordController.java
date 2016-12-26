package com.starlight.controller;

import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.serviceimp.ChangePasswordServiceImp;
import com.starlight.serviceimp.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Controller
public class ChangePasswordController {

    //用来记录改用户id方便其他操作
    private int u_id = 0;
    //获取对用户业务进行处理的对象
    @Resource
    private UserServiceImp userServiceImp;

    //获取对密保以及密码问题处理的对象
    @Resource
    private ChangePasswordServiceImp change_PasswordServiceImp;


    //进行判断密保问题域答案是否一致，进行下一步的修改密码操作等
    @RequestMapping("answer.do")
    @ResponseBody
    public String consistency_OfJudgment(String resultthree, String resultone, String resulttwo) {

        String[] result = new String[3];
        result[0] = resultone;
        result[1] = resulttwo;
        result[2] = resultthree;
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        //进行判断答案是否正确
        // 返回的是ajax的数据，不是页面的名字
        return change_PasswordServiceImp.Answer_Comparison(result, u_id);
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
    @RequestMapping("alertPpAll.do")
    //此注解不能省略 否则ajax无法接受返回值
    @ResponseBody
    public String alertPpAll(String[] result, User user, Wallet wallet, String password, String payment_code, String[] ppid) {
        //用户重置的密码
        user.setPassword(password);
        user.setId(u_id);
        //钱包
        wallet.setId(u_id);
        wallet.setPassword(Integer.parseInt(payment_code));
        return change_PasswordServiceImp.alertAllById(user, result, ppid, wallet);
    }

}

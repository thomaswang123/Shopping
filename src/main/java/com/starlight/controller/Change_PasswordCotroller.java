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
public class Change_PasswordCotroller {
    //用来记录改用户id方便其他操作
    private int u_id = 0;
    //获取对用户业务进行处理的对象
    @Resource
    private UserServiceImp userServiceImp;

    //获取对密保以及密码问题处理的对象
    @Resource
    private ChangePasswordServiceImp change_PasswordServiceImp;

    public ChangePasswordServiceImp getChange_PasswordServiceImp() {
        return change_PasswordServiceImp;
    }

    public void setChange_PasswordServiceImp(ChangePasswordServiceImp change_PasswordServiceImp) {
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
    @RequestMapping("alertPpAll.do")
    //此注解不能省略 否则ajax无法接受返回值
    @ResponseBody
    public String alertPpAll(String[] result,String password, String payment_code,String[] ppid){
        User user = new User();
        Wallet wallet = new Wallet();
            //用户重置的密码
            user.setPassword(password);
            user.setId(u_id);
        if(payment_code!=null&&payment_code!="") {
            //用户的钱包
            wallet.setId(u_id);
            wallet.setPassword(Integer.parseInt(payment_code));
            System.out.println(Integer.parseInt(payment_code));
        }else{
            wallet = null;
        }
        for (int i = 0; i<result.length ; i++) {
            if(result[i]==null&&result[i]==""){
                result = null;
            }
        }
        //判断是否为空
        if(change_PasswordServiceImp.alertAllById(user,wallet,result,ppid)!=null) {
            return "yes";
        }
        return null;
    }

}

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
 * 修改密码操作类
 */
@Controller
public class ChangePasswordController {

    //用来记录改用户id方便其他操作
    public int userId = 0;
    @Resource
    private UserServiceImp userServiceImp;
    @Resource
    private ChangePasswordServiceImp changePasswordSI;


    /**
     * 进行判断密保问题域答案是否一致，进行下一步的修改密码操作等
     * @param resultthree
     * @param resultone
     * @param resulttwo
     * @return
     */
    @RequestMapping("answer.do")
    @ResponseBody
    public String consistencyOfJudgment(String resultthree, String resultone, String resulttwo) {

        String[] result = new String[3];
        result[0] = resultone;
        result[1] = resulttwo;
        result[2] = resultthree;

        for (String str: result) {
            System.out.println(str);
        }

        // 返回的是ajax的数据，不是页面的名字
        return changePasswordSI.AnswerComparison(result, userId);
    }


    /**
     * 用来判断申请账号是否存在
     * @param username
     * @return
     */
    @RequestMapping("user_checkexist")
    @ResponseBody
    public String userCheckExist(String username) {
        //用户账号对应的id
        if ((userId = userServiceImp.bynameGainId(username)) != 0) {
            //这里反回值是ajax的回调函数中数据！不是页面
            return changePasswordSI.findQuestionAndIddByUid(userId);
        }
        return null;
    }

    /**
     * 修改密码，支付密码，密保答案
     * @param result
     * @param user
     * @param wallet
     * @param password
     * @param payment_code
     * @param ppid
     * @return
     */
    @RequestMapping("alertPpAll.do")
    @ResponseBody
    public String alertPpAll(String[] result, User user, Wallet wallet, String password, String payment_code, String[] ppid) {
        //用户重置的密码
        user.setPassword(password);
        user.setId(userId);
        //钱包
        wallet.setId(userId);
        wallet.setPassword(Integer.parseInt(payment_code));
        return changePasswordSI.alertAllById(user, result, ppid, wallet);
    }

}

package com.starlight.controller;

import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.service.IChangePasswordService;
import com.starlight.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by thomas.wang on 2016/12/20.
 * 修改密码操作类
 */
@Controller
public class ChangePasswordController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IChangePasswordService iChangePasswordService;


    /**
     * 进行判断密保问题域答案是否一致，进行下一步的修改密码操作等
     * @param resultthree
     * @param resultone
     * @param resulttwo
     * @return
     */
    @RequestMapping("answer.do")
    @ResponseBody
    public String consistencyOfJudgment(String resultthree, String resultone, String resulttwo, HttpSession httpSession) {

        String[] result = new String[3];
        result[0] = resultone;
        result[1] = resulttwo;
        result[2] = resultthree;

        for (String str: result) {
            System.out.println(str);
        }
       int userId=(Integer) httpSession.getAttribute("userId");
        // 返回的是ajax的数据，不是页面的名字
        return iChangePasswordService.AnswerComparison(result, userId);
    }

    /**
     * 用来判断申请账号是否存在
     * @param username
     * @return
     */
    @RequestMapping("user_checkexist")
    @ResponseBody
    public String userCheckExist(String username,HttpSession httpSession) {

        int userId=(Integer)httpSession.getAttribute("userId");
        //用户账号对应的id
        if ((userId = iUserService.bynameGainId(username)) != 0) {
            //这里反回值是ajax的回调函数中数据！不是页面
            return iChangePasswordService.findQuestionAndIddByUid(userId);
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
    public String alertPpAll(String[] result, User user, Wallet wallet, String password, String payment_code, String[] ppid,HttpSession httpSession) {
        int userId=(Integer)httpSession.getAttribute("userId");
        //用户重置的密码
        user.setPassword(password);
        user.setId(userId);
        //钱包
        wallet.setId(userId);
        wallet.setPassword(Integer.parseInt(payment_code));
        return iChangePasswordService.alertAllById(user, result, ppid, wallet);
    }

}

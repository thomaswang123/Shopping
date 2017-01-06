package com.starlight.controller;

import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.service.IChangePasswordService;
import com.starlight.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by thomas.wang on 2016/12/20.
 * 修改密码操作类
 */
@Controller
public class ChangePasswordController {

    /**用户账号业务*/
    @Resource
    private IUserService iUserService;

    /**密保业务*/
    @Resource
    private IChangePasswordService iChangePasswordService;


    /**
     * 进行判断密保问题域答案是否一致，进行下一步的修改密码操作等
     * @param resultthree   答案三
     * @param resultone     答案一
     * @param resulttwo     答案二
     * @return  ajax提示信息
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
     * @param username  输入的账号
     * @return  ajax的提示信息
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
     * @param result 答案数组
     * @param password  密码
     * @param payment_code  支付密码
     * @param ppid  支付id
     * @param httpSession session
     * @return 密保
     */
    @RequestMapping("alertPpAll.do")
    @ResponseBody
    public String alertPpAll(String[] result,String password, String payment_code, String[] ppid,HttpSession httpSession) {
        int userId=(Integer)httpSession.getAttribute("userId");
        //用户重置的密码
        User user=new User();
        user.setPassword(password);
        user.setId(userId);
        //钱包
        Wallet wallet=new Wallet();
        wallet.setId(userId);
        wallet.setPassword(Integer.parseInt(payment_code));
        return iChangePasswordService.alertAllById(user, result, ppid, wallet);
    }

}

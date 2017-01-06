package com.starlight.serviceimp;

import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.service.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/21.
 */
@Service
public class ChangePasswordServiceImp implements IChangePasswordService {
    @Autowired
    private IChangePasswordDao iChangePasswordDao;
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private IWalletDao iWalletDao;

    //查找pp_answer进行答案的判断
    @Transactional
    public String AnswerComparison(String[] result, int userid) {
        //用来取出result中的数据
        String[] string = iChangePasswordDao.findAnswerById(userid);
        int temp = 1;
        for (int i = 0; i < string.length; i++) {
            if (string[i].equals(result[i])) {
                System.out.println(string[i]);
                temp++;
            }
        }
        if (temp == 4) {
            return "yes";
        }
        return null;
    }


    //用来处理密保,查询密保并展示到前台页面
    @Transactional
    public String findQuestionAndIddByUid(int userId) {
        String string = "";
        //记录分隔符“,”
        int temp = 1;
        //条用dao进行对数据库的查询
        List<PassWordProtection> lists =
               iChangePasswordDao.findQuestionAndIddByUid(userId);
        for (PassWordProtection lt : lists
                ) {
            string += "" + lt.getId() + "," + lt.getQuestion();
            if (temp < 3) {
                string += ",";
            }
            temp++;
        }
        return string;
    }



    //进行对密保答案，密码，支付密码的修改！*需要事务管理进行管理
    @Transactional
    public String alertAllById(User user, String[] result, String[] ppid, Wallet wallet) {
        System.out.println(user.getPassword());
        System.out.println(result[2]);
        System.out.println(wallet.getPassword());
        //判断用户密码是否为空
        if (user.getPassword() != null && user.getPassword().length() >= 6 && user.getPassword() != "") {
            alertPwd(user);
            //判断钱包是否为空
            if (wallet.getPassword() != 0 && wallet.getPassword() + "".length() >= 6) {
                alertPayPwd(wallet);
            }
            //判断密保答案是否为空
            if (answerIsEmpty(result) == 4) {
                alertAnswer(result, ppid);
            }
            return "yes";
        }
        return null;
    }

    //判断用户密保答案是否为空
    @Transactional
    public int answerIsEmpty(String[] result) {
        int temp = 1;
        for (int k = 0; k < result.length; k++) {
            if (result[k] != null && result[k] != "") {
                temp++;
            }
        }
        System.out.println(temp);
        return temp;
    }

    //修改用户密码
    @Transactional
    public void alertPwd(User user) {
        //进行用户密码修改
       iUserDao.alertPwdById(user);
    }

    //修改用户钱包支付密码
    @Transactional
    public void alertPayPwd(Wallet wallet) {
        //进行用户钱包的修改
       iWalletDao.alertPayPwdById(wallet);
    }

    //修改用户密保答案
    @Transactional
    public void alertAnswer(String[] result, String[] ppid) {
        //进行密保答案的查询
        for (int i = 0; i < ppid.length; i++) {
            PassWordProtection pwp = new PassWordProtection();
            pwp.setId(Integer.parseInt(ppid[i]));
            pwp.setAnswer(result[i]);
          iChangePasswordDao.alterPWP(pwp);
        }
    }

}

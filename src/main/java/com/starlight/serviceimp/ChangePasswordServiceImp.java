package com.starlight.serviceimp;

import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.service.IChangePasswordService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/21.
 */
@Transactional(rollbackFor = Exception.class) //指定回滚,遇到异常Exception时回滚
@Component
public class ChangePasswordServiceImp implements IChangePasswordService {

    //用来处理密保,查询密保并展示到前台页面
    public String findQuestionAndIddByUid(int u_id) {
        String string = "";
        //记录分隔符“,”
        int temp = 1;
        //条用dao进行对数据库的查询
        List<PassWordProtection> lists =
                Appliction.getAct().getBean(IChangePasswordDao.class).findQuestionAndIddByUid(u_id);
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

//查找pp_answer进行答案的判断

    public String Answer_Comparison(String[] result, int u_id) {
        //用来取出result中的数据
        String[] string = Appliction.getAct().getBean(IChangePasswordDao.class).findAnswerById(u_id);
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

    //进行对密保答案，密码，支付密码的修改！*需要事务管理进行管理
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
    public void alertPwd(User user) {
        //进行用户密码修改
        Appliction.getAct().getBean(IUserDao.class).alertPwdById(user);
    }

    //修改用户钱包支付密码
    public void alertPayPwd(Wallet wallet) {
        //进行用户钱包的修改
        Appliction.getAct().getBean(IWalletDao.class).alertPayPwdById(wallet);
    }

    //修改用户密保答案
    public void alertAnswer(String[] result, String[] ppid) {
        //进行密保答案的查询
        for (int i = 0; i < ppid.length; i++) {
            PassWordProtection pwp = new PassWordProtection();
            pwp.setId(Integer.parseInt(ppid[i]));
            pwp.setAnswer(result[i]);
            Appliction.getAct().getBean(IChangePasswordDao.class).alterPWP(pwp);
        }
    }


}

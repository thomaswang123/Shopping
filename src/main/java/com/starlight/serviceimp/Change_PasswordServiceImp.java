package com.starlight.serviceimp;

import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.PasswordProtection;
import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.service.IChange_PasswordService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/21.
 */
@Component
public class Change_PasswordServiceImp implements IChange_PasswordService {

    //用来处理密保,查询密保并展示到前台页面
    public String findQuestionAndIddByUid(int u_id) {
        String string = "" ;
        //记录分隔符“,”
        int temp = 1;
        //条用dao进行对数据库的查询
        List<PasswordProtection> lists =
                Appliction.getAct().getBean(IChangePasswordDao.class).findQuestionAndIddByUid(u_id);
        for (PasswordProtection lt:lists
                ) {
            string += ""+lt.getPp_id()+"," + lt.getPp_question() ;
            if(temp<3) {
                string += ",";
            }
            temp ++;
        }
          return string;
    }

    //查找pp_answer进行答案的判断

    public String Answer_Comparison(int u_id,String[] result) {
            //用来取出result中的数据
            int temp = 0;
            for (PasswordProtection
                    ls : Appliction.getAct().getBean(IChangePasswordDao.class).findAnswerById(u_id)
                    ) {
                if (ls.getPp_answer().equals(result[temp])) {
                    temp++;
                } else {
                    return null;
                }
            }
            return "yes";
    }

    //进行对密保答案，密码，支付密码的修改！*需要事务管理进行管理
    public String alertAllById(User user, Wallet wallet, String[] result) {
        //进行用户密码修改
        int usertemp = Appliction.getAct().getBean(IUserDao.class).alertPwdById(user);
        //进行用户的钱包的修改
        int walletemp  = Appliction.getAct().getBean(IWalletDao.class).alertPayPwdById(wallet);
        //查询数据
        return null;
    }
}

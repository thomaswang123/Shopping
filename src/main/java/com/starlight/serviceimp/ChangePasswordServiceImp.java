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
@Transactional(rollbackFor=Exception.class) //指定回滚,遇到异常Exception时回滚
@Component
public class ChangePasswordServiceImp implements IChangePasswordService {

    //用来处理密保,查询密保并展示到前台页面
    public String findQuestionAndIddByUid(int u_id) {
        String string = "" ;
        //记录分隔符“,”
        int temp = 1;
        //条用dao进行对数据库的查询
        List<PassWordProtection> lists =
                Appliction.getAct().getBean(IChangePasswordDao.class).findQuestionAndIddByUid(u_id);
        for (PassWordProtection lt:lists
                ) {
            string += ""+lt.getId()+"," + lt.getQuestion() ;
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
            String[] string = Appliction.getAct().getBean(IChangePasswordDao.class).findAnswerById(u_id);
            for (int temp = 0; temp<string.length;temp++
                    ) {
                if (string[temp].equals(result[temp])&&temp==2) {
                    return "yes";
                }
            }
           return null;
    }

    //进行对密保答案，密码，支付密码的修改！*需要事务管理进行管理
    public String alertAllById(User user, Wallet wallet, String[] result,String[] ppid) {
        //进行用户密码修改
        int usertemp = Appliction.getAct().getBean(IUserDao.class).alertPwdById(user);
      
        if(wallet!=null&&ppid!=null&&result!=null){
            //进行用户的钱包的修改
            int walletemp = Appliction.getAct().getBean(IWalletDao.class).alertPayPwdById(wallet);
            int pwptemp = 0;
            //插入密保问题
            for (int i = 0; i < ppid.length; i++) {
                PassWordProtection pwp = new PassWordProtection();
                pwp.setId(Integer.parseInt(ppid[i]));
                pwp.setAnswer(result[i]);
                //添加对象
                 pwptemp = Appliction.getAct().getBean(IChangePasswordDao.class).alterPWP(pwp);
            }
            if (usertemp != 0 && walletemp != 0 && pwptemp >1) {
                return "yes";
            }
            return null;
        }
        
        if(wallet==null&&ppid!=null&&result!=null){
            //插入密保问题
            int pwptemp = 0;
            for (int i = 0; i < ppid.length; i++) {
                PassWordProtection pwp = new PassWordProtection();
                pwp.setId(Integer.parseInt(ppid[i]));
                pwp.setAnswer(result[i]);
                //添加对象
              pwptemp += Appliction.getAct().getBean(IChangePasswordDao.class).alterPWP(pwp);
            }
            if(pwptemp==3){
                return "yes";
            }
            return null;
        }else{
            //进行用户的钱包的修改
            int walletemp = Appliction.getAct().getBean(IWalletDao.class).alertPayPwdById(wallet);
            if(walletemp!=0){
                return "yes";
            }
            return null;
        }
    }
}

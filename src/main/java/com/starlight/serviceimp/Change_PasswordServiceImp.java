package com.starlight.serviceimp;

import com.starlight.dao.Change_PasswordDao;
import com.starlight.dao.UserDao;
import com.starlight.entity.PasswordProtecTion;
import com.starlight.service.Change_PasswordService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by thomas.wang on 2016/12/21.
 */
@Component
public class Change_PasswordServiceImp implements Change_PasswordService {

    //用来处理密保,查询密保并展示到前台页面
    public String findQuestionById(int u_id) {
        String string = "" ;
        //记录分隔符“,”
        int temp = 1;
        //条用dao进行对数据库的查询
        List<PasswordProtecTion> lists =
                Appliction.getAct().getBean(Change_PasswordDao.class).findQuestionById(u_id);

        for (PasswordProtecTion lt:lists
                ) {
            string += "" + lt.getPp_question() ;
            if(temp<3) {
                string += ",";
            }
            temp ++;
        }
          return string;
    }

    //查找pp_answer进行答案的判断

    public String Answer_Comparison(int u_id,String[] result) {
        try {
            //用来取出result中的数据
            int temp = 0;
            for (PasswordProtecTion
                    ls : Appliction.getAct().getBean(Change_PasswordDao.class).findAnswerById(u_id)
                    ) {
                if (ls.getPp_answer().equals(result[temp])) {
                    temp++;
                } else {
                    return null;
                }
            }
            return "yes";
        }catch (NullPointerException e){
            System.out.println("ls，result，出现空指针");
        }finally {
            return null;
        }
    }

    //进行对密保答案，密码，支付密码的修改！*需要事务管理进行管理
    public String alertAllById(int u_id,String pwd,String paypwd,String[] result) {

       if(paypwd!=null){

       }else if(result!=null){

       }
        return "aaa";
    }
}

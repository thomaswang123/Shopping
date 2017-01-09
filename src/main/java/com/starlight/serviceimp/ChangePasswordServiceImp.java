package com.starlight.serviceimp;

import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.entity.Wallet;
import com.starlight.service.IChangePasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/21.
 * 密保业务
 */
@Service
public class ChangePasswordServiceImp implements IChangePasswordService {

    /**密保sql接口*/
    @Resource
    private IChangePasswordDao iChangePasswordDao;

    /**用户sql接口*/
    @Resource
    private IUserDao iUserDao;

    /**用户钱包sql接口*/
    @Resource
    private IWalletDao iWalletDao;

    /**
     * 查找pp_answer进行答案的判断
     * @param result    答案
     * @param userid    用户id
     * @return  提示信息
     */
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

    /**
     * 用来处理密保,查询密保并展示到前台页面
     * @param userId    用户id
     * @return  密保问题
     */
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

    /**
     * 进行对密保答案，密码，支付密码的修改！*需要事务管理进行管理
     * @param user   用户对象
     * @param result  密保答案
     * @param ppid  密保id
     * @param wallet    用户钱包对象
     * @return  提示信息
     */
    @Transactional
    public String alertAllById(User user, String[] result, String[] ppid, Wallet wallet) {
        System.out.println(user.getPassword());
        System.out.println(result[2]);
        System.out.println(wallet.getPassword());
        //判断用户密码是否为空
        if (user.getPassword() != null && user.getPassword().length() >= 6 &&"".equals(user.getPassword())) {
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

    /**
     * 判断用户密保答案是否为空
     * @param result    答案
     * @return  返回正确数
     */
    @Transactional
    private int answerIsEmpty(String[] result) {
        int temp = 1;
        for (String aResult : result) {
            if (aResult != null && " ".equals(aResult)) {
                temp++;
            }
        }
        System.out.println(temp);
        return temp;
    }

    /**
     * 修改用户密码
     * @param user  用户
     */
    @Transactional
    private void alertPwd(User user) {
        //进行用户密码修改
       iUserDao.alertPwdById(user);
    }

    /**
     * 修改用户钱包支付密码
     * @param wallet    钱包
     */
    @Transactional
    private void alertPayPwd(Wallet wallet) {
        //进行用户钱包的修改
       iWalletDao.alertPayPwdById(wallet);
    }

    /**
     * 修改用户密保答案
     * @param result    密保答案
     * @param ppid      密保id
     */
    @Transactional
    private void alertAnswer(String[] result, String[] ppid) {
        //进行密保答案的查询
        for (int i = 0; i < ppid.length; i++) {
            PassWordProtection pwp = new PassWordProtection();
            pwp.setId(Integer.parseInt(ppid[i]));
            pwp.setAnswer(result[i]);
          iChangePasswordDao.alterPWP(pwp);
        }
    }

}

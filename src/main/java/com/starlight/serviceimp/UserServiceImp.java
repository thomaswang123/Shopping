package com.starlight.serviceimp;


import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.service.IUserService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Service
@Transactional
public class UserServiceImp implements IUserService {
    //用户信息
    @Resource
    IUserDao iUserDao;
    @Resource
    IChangePasswordDao iChangePasswordDao;

    //登陆
    public int login(User user) {
        IUserDao userdao = Appliction.getAct().getBean(IUserDao.class);
        return  userdao.login(user);
    }

    public List<String> findAllNameById(List<Integer> list) {
        return null;
    }

    public List<Integer> findAllId(int number) {
        return null;
    }


    //根据用户账号来查询id，用于判断账号是否存在
    public int byname_GainId(String u_name) {
        
        return Appliction.getAct().getBean(IUserDao.class).findIdByAccoun_Unmber(u_name);
    }

    public boolean byname_JudgeUserNameExist(String u_name) {
        return false;
    }

//    用户注册
    public int register(User user){
        iUserDao.register(user);
        return iUserDao.findIdByUser(user.getAccount());
    }
//    添加密保
    public void addPWP(PassWordProtection passWordProtection){
        iChangePasswordDao.addPWP(passWordProtection);
    }

    public List<User> findAccount(String account){
        return iUserDao.findAccount(account);
    }
}

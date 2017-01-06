package com.starlight.serviceimp;


import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.entity.Paging;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Service
public class UserServiceImp implements IUserService {
    //用户信息
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private IChangePasswordDao iChangePasswordDao;

    //登陆
    @Transactional
    public int login(User user) {
        return iUserDao.login(user);
    }

    //根据用户账号来查询id，用于判断账号是否存在
    @Transactional
    public int bynameGainId(String username) {
        return iUserDao.findIdByAccounUnmber(username);
    }

    //    用户注册
    @Transactional
    public int register(User user) {
        iUserDao.register(user);
        return iUserDao.findIdByUser(user.getAccount());
    }
//    添加密保
    @Transactional
    public void addPWP(PassWordProtection passWordProtection){
        iChangePasswordDao.addPWP(passWordProtection);
    }

    //    通过账号查找是否存在该用户
    @Transactional
    public List<User> findAccount(String account){
        return iUserDao.findAccount(account);
    }

    //      通过ID查找用户账号
    @Transactional
    public User findAccountById(int userId) {
        return iUserDao.findAccountById(userId);
    }

//    根据账号条件来模糊查询的总数量
    @Transactional
    public int findByLikeNameNumber(Paging paging) {
        return iUserDao.findByLikeNameNumber(paging);
    }
}

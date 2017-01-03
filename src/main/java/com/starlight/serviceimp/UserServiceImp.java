package com.starlight.serviceimp;


import com.starlight.dao.IChangePasswordDao;
import com.starlight.dao.IUserDao;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.service.IUserService;
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
    private IUserDao iUserDao;
    @Resource
    private IChangePasswordDao iChangePasswordDao;

    //登陆
    public int login(User user) {
        return iUserDao.login(user);
    }

    //根据用户账号来查询id，用于判断账号是否存在
    public int bynameGainId(String username) {
        return iUserDao.findIdByAccounUnmber(username);
    }

    //    用户注册
    public int register(User user) {
        iUserDao.register(user);
        return iUserDao.findIdByUser(user.getAccount());
    }
//    添加密保
    public void addPWP(PassWordProtection passWordProtection){
        iChangePasswordDao.addPWP(passWordProtection);
    }

    //    通过账号查找是否存在该用户
    public List<User> findAccount(String account){
        return iUserDao.findAccount(account);
    }

    //      通过ID查找用户账号
    public User findAccountById(int userId) {
        return iUserDao.findAccountById(userId);
    }
}

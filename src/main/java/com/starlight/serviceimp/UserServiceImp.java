package com.starlight.serviceimp;


import com.starlight.dao.UserDao;
import com.starlight.entity.User;
import com.starlight.service.IUserService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public class UserServiceImp implements IUserService {

    //登陆
    public int login(User user) {
        UserDao userdao = Appliction.getAct().getBean(UserDao.class);
        return  userdao.login(user);
    }

    public List<String> findAllNameById(List<Integer> list) {
        return null;
    }

    public List<Integer> findAllId(int number) {
        return null;
    }

    public int byname_GainId(String u_name) {
        return 0;
    }

    public boolean byname_JudgeUserNameExist(String u_name) {
        return false;
    }
}
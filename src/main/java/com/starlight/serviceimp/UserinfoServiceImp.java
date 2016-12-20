package com.starlight.serviceimp;

import com.starlight.dao.UserinfoDao;
import com.starlight.entity.Userinfo;
import com.starlight.service.IUserinfoService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public class UserinfoServiceImp implements IUserinfoService{
    public List<Userinfo> findAllUserinfoById(List<Integer> list) {
        return null;
    }

    public List<Userinfo> findUserinfoByAge(int age) {
        return null;
    }

    public List<Userinfo> findUserinfoByNickName(String uinfo_nickname) {
        return null;
    }

    public boolean alterPhoneById(int id) {
        return false;
    }

    //查询用户信息返回一个List用户信息集合
    public Userinfo findUserinfosById(int u_id) {
        UserinfoDao userifodao = Appliction.getAct().getBean(UserinfoDao.class);
        return  userifodao.findUserifoById(u_id);
    }
}

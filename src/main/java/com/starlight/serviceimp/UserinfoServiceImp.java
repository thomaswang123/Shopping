package com.starlight.serviceimp;

import com.starlight.dao.IUserDao;
import com.starlight.dao.IUserinfoDao;
import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.service.IUserinfoService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public class UserinfoServiceImp implements IUserinfoService{
    
    //用户信息
    @Resource
    IUserinfoDao iUserinfoDao;

    //通过分页来查询数据！
    public List<UserInfo> byPagingfindAll(Paging paging) {
        return Appliction.getAct().getBean(IUserinfoDao.class).byPagingfindAll(paging);
    }

    //处理数据的总数量
    public int countUserIdNumber() {
        return Appliction.getAct().getBean(IUserDao.class).countAllIdNumber();
    }

    public List<UserInfo> findUserinfoByAge(int age) {
        return null;
    }

    public List<UserInfo> findUserinfoByNickName(String uinfo_nickname) {
        return null;
    }

    public boolean alterPhoneById(int id) {
        return false;
    }

    //查询用户信息返回一个List用户信息集合
    public UserInfo findUserinfosById(int u_id) {
        IUserinfoDao userifodao = Appliction.getAct().getBean(IUserinfoDao.class);
        return  userifodao.findUserifoById(u_id);
    }
}

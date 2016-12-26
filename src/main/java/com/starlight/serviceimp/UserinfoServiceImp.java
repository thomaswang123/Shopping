package com.starlight.serviceimp;

import com.starlight.dao.IUserInfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;
import com.starlight.service.IUserinfoService;
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
public class UserinfoServiceImp implements IUserinfoService{
    
    //用户信息
    @Resource
    IUserInfoDao iUserinfoDao;
    @Resource
    IWalletDao iWalletDao;

    
    public List<UserInfo> findAllUserinfoById(List<Integer> list) {
        return null;
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
        IUserInfoDao userifodao = Appliction.getAct().getBean(IUserInfoDao.class);
        return  userifodao.findUserifoById(u_id);
    }
//    插入用户详细信息
    public void register(UserInfo userInfo){
        iUserinfoDao.register(userInfo);
    }
//    注册用户钱包
    public void registerWallet(Wallet wallet){
        iWalletDao.register(wallet);
    }

}

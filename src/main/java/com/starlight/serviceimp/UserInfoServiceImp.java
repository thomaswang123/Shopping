package com.starlight.serviceimp;

import com.starlight.dao.IUserInfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;
import com.starlight.service.IUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Service
@Transactional
public class UserInfoServiceImp implements IUserInfoService {
    
    //用户信息
    @Resource
    IUserInfoDao iUserinfoDao;
    @Resource
    IWalletDao iWalletDao;


    public List<UserInfo> findAllUserInfoById(List<Integer> list) {
        return null;
    }

    public List<UserInfo> findUserInfoByNickName(String uinfo_nickname) {
        return null;
    }

    public List<UserInfo> findUserInfoByAge(int age) {
        return null;
    }

    public UserInfo findUserInfoById(int id) {
        return iUserinfoDao.findUserInfoById(id);
    }

    public boolean alterPhoneById(int id) {
        return false;
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

package com.starlight.serviceimp;

import com.starlight.dao.IUserDao;
import com.starlight.dao.IUserInfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;
import com.starlight.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Service
public class UserInfoServiceImp implements IUserInfoService {

    //用户信息
    @Autowired
    private IUserInfoDao iUserInfoDao;
    @Autowired
    private IWalletDao iWalletDao;
    @Autowired
    private IUserDao iUserDao;


    //处理数据的总数量
    @Transactional
    public int countUserIdNumber() {
        return iUserDao.countAllIdNumber();
    }
    @Transactional
    public List<UserInfo> findAllUserInfoById(int userId) {


        return iUserInfoDao.findAllUserInfoById(userId);
    }
    @Transactional
    public List<UserInfo> findUserInfoByNickName(String nickname) {

        return null;
    }
    @Transactional
    public List<UserInfo> findUserInfoByAge(int age) {

        return null;
    }
    @Transactional
    public boolean alterPhoneById(int id) {
        return false;
    }
    @Transactional
    public UserInfo findUserInfoById(int userId) {

        return iUserInfoDao.findUserInfoById(userId);
    }

    //    插入用户详细信息
    @Transactional
    public void register(UserInfo userInfo) {


        iUserInfoDao.register(userInfo);
    }

    //    注册用户钱包
    @Transactional
    public void registerWallet(Wallet wallet) {
        iWalletDao.register(wallet);
    }


    //根据分页的页码来分页
    @Transactional
    public List<UserInfo> pagination(String pagination,String number) {
        System.out.println("aaaaa"+number+pagination);
        //页面的数据数量
        int nbr = Integer.parseInt(number.substring(number.indexOf(":")+1,number.length()));
        //页码
        int pat = Integer.parseInt(pagination);
        Paging paging=new Paging();
        if(pat==1) {
            //从第几个数据开始
            paging.setRise(pat * nbr - nbr);
            //那个数据结束
            paging.setStop(pat * nbr);
        }else{
            //从第几个数据开始
            paging.setRise(pat * nbr-nbr);
            //那个数据结束
            paging.setStop(nbr);
            System.out.println(pat * nbr - nbr+","+nbr);
        }
        List<UserInfo> list = iUserInfoDao.byPagingfindAll(paging);
        for (int i = 0; i <list.size() ; i++) {
            list.get(i).setColor(i);
            System.out.println(list.get(i).getNickname());
        }
        return list;
    }


    //通过分页来查询数据！
    @Transactional
    public List<UserInfo> byPagingfindAll(Paging paging) {

        List<UserInfo> list = iUserInfoDao.byPagingfindAll(paging);
        //添加颜色
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColor(i+1);
        }
        return list;
    }

//    修改昵称
    @Transactional
    public void updateNickName(UserInfo userInfo) {
        iUserInfoDao.updateNickName(userInfo);
    }

//    修改年龄
    @Transactional
    public void updateUserAge(UserInfo userInfo) {
        iUserInfoDao.updateUserAge(userInfo);
    }
//  修改手机号
    @Transactional
    public void updateUserPhone(UserInfo userInfo) {
        iUserInfoDao.updateUserPhone(userInfo);
    }
//  修改地址
    @Transactional
    public void updateUserAddress(UserInfo userInfo) {
        iUserInfoDao.updateUserAddress(userInfo);
    }
}

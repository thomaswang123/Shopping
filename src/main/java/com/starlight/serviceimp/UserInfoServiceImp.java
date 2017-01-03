package com.starlight.serviceimp;

import com.starlight.dao.IUserDao;
import com.starlight.dao.IUserInfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.Paging;
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
    private IUserInfoDao iUserinfoDao;
    @Resource
    private IWalletDao iWalletDao;
    @Resource
    private Paging paging;
    @Resource
    private IUserDao iUserDao;

    //处理数据的总数量
    public int countUserIdNumber() {
        return iUserDao.countAllIdNumber();
    }

    public List<UserInfo> findAllUserInfoById(int userId) {


        return iUserinfoDao.findAllUserInfoById(userId);
    }

    public List<UserInfo> findUserInfoByNickName(String nickname) {

        return null;
    }

    public List<UserInfo> findUserInfoByAge(int age) {

        return null;
    }

    public boolean alterPhoneById(int userId) {


        return false;
    }

    public UserInfo findUserInfoById(int userId) {

        return iUserinfoDao.findUserInfoById(userId);
    }

    //    插入用户详细信息
    public void register(UserInfo userInfo) {


        iUserinfoDao.register(userInfo);
    }

    //    注册用户钱包
    public void registerWallet(Wallet wallet) {
        iWalletDao.register(wallet);
    }


    //根据分页的页码来分页
    public List<UserInfo> pagination(String pagination,String number) {
        System.out.println("aaaaa"+number+pagination);
        //页面的数据数量
        int nbr = Integer.parseInt(number.substring(number.indexOf(":")+1,number.length()));
        //页码
        int pat = Integer.parseInt(pagination);
        //从第几个数据开始
        paging.setRise(pat*nbr-nbr);
        //那个数据结束
        paging.setStop(pat*nbr);
        List<UserInfo> list = iUserinfoDao.byPagingfindAll(paging);
        for (int i = 0; i <list.size() ; i++) {
            list.get(i).setColor(i);
            System.out.println(list.get(i).getNickname());
        }
        return list;
    }


    //通过分页来查询数据！
    public List<UserInfo> byPagingfindAll(Paging paging) {

        List<UserInfo> list = iUserinfoDao.byPagingfindAll(paging);
        //添加颜色
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColor(i+1);
        }
        return list;
    }

//    修改昵称
    public void updateNickName(UserInfo userInfo) {
        iUserinfoDao.updateNickName(userInfo);
    }

//    修改年龄
    public void updateUserAge(UserInfo userInfo) {
        iUserinfoDao.updateUserAge(userInfo);
    }
//  修改手机号
    public void updateUserPhone(UserInfo userInfo) {
        iUserinfoDao.updateUserPhone(userInfo);
    }
//  修改地址
    public void updateUserAddress(UserInfo userInfo) {
        iUserinfoDao.updateUserAddress(userInfo);
    }
}

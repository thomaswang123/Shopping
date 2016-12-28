package com.starlight.serviceimp;

import com.starlight.dao.IUserDao;
import com.starlight.dao.IUserInfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;
import com.starlight.service.IUserInfoService;
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
public class UserInfoServiceImp implements IUserInfoService {

    //用户信息
    @Resource
    IUserInfoDao iUserinfoDao;
    @Resource
    IWalletDao iWalletDao;
    @Resource
    Paging paging;
    @Resource
    IUserDao iUserDao;

    //处理数据的总数量
    public int countUserIdNumber() {
        return Appliction.getAct().getBean(IUserDao.class).countAllIdNumber();
    }

    public List<UserInfo> findAllUserInfoById(int id) {


        return iUserinfoDao.findAllUserInfoById(id);
    }

    public List<UserInfo> findUserInfoByNickName(String uinfo_nickname) {


        return null;
    }

    public List<UserInfo> findUserInfoByAge(int age) {


        return null;
    }

    public boolean alterPhoneById(int id) {


        return false;
    }

    public UserInfo findUserInfoById(int id) {

        return iUserinfoDao.findUserInfoById(id);
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

        List<UserInfo> list = Appliction.getAct().getBean(IUserInfoDao.class).byPagingfindAll(paging);
        //添加颜色
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setColor(i+1);
        }
        return list;
    }
}

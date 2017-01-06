package com.starlight.serviceimp;

import com.starlight.dao.IUserDao;
import com.starlight.dao.IUserInfoDao;
import com.starlight.dao.IWalletDao;
import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.service.IUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 用户详细信息业务类
 */
@Service
public class UserInfoServiceImp implements IUserInfoService {

    /**用户信息sql接口*/
    @Resource
    private IUserInfoDao iUserInfoDao;

    /**用户钱包sql接口*/
    @Resource
    private IWalletDao iWalletDao;

    /**用户账号sql接口*/
    @Resource
    private IUserDao iUserDao;

    /**
     * 获取数据库中用户数量
     * @return  用户量
     */
    @Transactional
    public int countUserIdNumber() {
        return iUserDao.countAllIdNumber();
    }

    /**
     * 查找用户信息
     * @param userId    用户id
     * @return  用户详细信息
     */
    @Transactional
    public UserInfo findUserInfoById(int userId) {

        return iUserInfoDao.findUserInfoById(userId);
    }

    /**
     * 插入用户详细信息
     * @param userInfo  用户详细信息
     */
    @Transactional
    public void register(UserInfo userInfo) {


        iUserInfoDao.register(userInfo);
    }

    /**
     * 根据分页的页码来分页
     * @param pagination    页码
     * @param number
     * @return  用户信息集合
     */
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

    /**
     * 修改昵称
     * @param userInfo 用户信息
     */
    @Transactional
    public void updateNickName(UserInfo userInfo) {
        iUserInfoDao.updateNickName(userInfo);
    }

    /**
     * 修改年龄
     * @param userInfo  用户信息
     */
    @Transactional
    public void updateUserAge(UserInfo userInfo) {
        iUserInfoDao.updateUserAge(userInfo);
    }

    /**
     * 修改手机号
     * @param userInfo  用户信息
     */
    @Transactional
    public void updateUserPhone(UserInfo userInfo) {
        iUserInfoDao.updateUserPhone(userInfo);
    }

    /**
     * 修改地址
     * @param userInfo  用户信息
     */
    @Transactional
    public void updateUserAddress(UserInfo userInfo) {
        iUserInfoDao.updateUserAddress(userInfo);
    }
}

package com.starlight.serviceimp;

import com.starlight.dao.*;
import com.starlight.entity.*;
import com.starlight.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
@Service
public class AdminServiceImp implements IAdminService {


    @Autowired
    IAdminDao iAdminDao;

    @Autowired
    IUserInfoDao iUserInfoDao;

    @Autowired
    IUserDao iUserDao;

    @Autowired
    IChangePasswordDao iChangePasswordDao;

    @Autowired
    IOpinionDao iOpinionDao;

    @Autowired
    IOrderDao iOrderDao;

    @Autowired
    IShoppingCartDao iShoppingCartDao;

    @Autowired
    IWalletDao iWalletDao;
    @Autowired
    IGoodsDao iGoodsDao;

    @Autowired
    IRepertoryDao iRepertoryDao;

    @Transactional
    public void addAdmin(Admin admin) {
        iAdminDao.addAdmin(admin);
    }

    //查询管理员的等级
    @Transactional
    public int findClassesById(int u_id) {
        return iAdminDao .findClassesById(u_id);

    }

    //删除用户所有数据的操作
    @Transactional
    public int delAllUserData(int uid) {
        int uftemp = 0, cls = 0, wle = 0, on = 0, pwp = 0, shopping = 0, os = 0, user = 0;
        try {
            //用户信息
            uftemp = iUserInfoDao.delUserInfo(uid);
            //钱包
            wle = iWalletDao.delWakket(uid);
            //密保
            pwp = iChangePasswordDao.deletePwp(uid);
            //管理员
            cls = iAdminDao.delAllUserData(uid);
        } catch (Exception e) {
            //用户
            user = iUserDao.delUser(uid);
        }
        if (cls != 0 || wle != 0 || pwp != 0
               || os != 0 || user != 0 || uftemp != 0) {
            return 1;
        }
        return 0;
    }

    //查询商品
    @Transactional
    public List<Goods> findAllByPaging(Paging paging) {
        //赋值，进行页面展示
        return iGoodsDao.byPagingfindAll(paging);
    }

    //查询数据总数量
    @Transactional
    public int conutGoodsDataNumber() {
        return iGoodsDao.conutGoodsNumber();
    }


    //根据分页的页码来展示数据
    @Transactional
    public List<Goods> pagination(String pagination, String number) {
        Paging paging=new Paging();
        //页面的数据数量
        int nbr = Integer.parseInt(number.substring(number.indexOf(":") + 1, number.length()));
        //页码
        int pat = Integer.parseInt(pagination);
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
        return iGoodsDao.byPagingfindAll(paging);
    }

    //查询有关管理员的信息
    @Transactional
    public List<UserInfo> findAdminByPaging(Paging paging) {
        List<UserInfo> list = iUserInfoDao.byPagingfindAll(paging);
        for (int i = 0; i < list.size(); i++) {
            //颜色
            list.get(i).setColor(i + 1);
            //管理级别
            list.get(i).setClasses(iAdminDao.findClassesById(list.get(i).getUser().getId()));
        }
        return list;
    }

    //修改商品信息和库存的信息
    @Transactional
    public int alterGoodsData(Goods goods, Repertory repertory) {
        int goodsTemp = iGoodsDao.alterGoods(goods);
        int repertoryTemp = iRepertoryDao.alterRepertory(repertory);
        return goodsTemp + repertoryTemp;
    }

    //删除商品信息
    @Transactional
    public int delGoodsData(int id) {
        int repertoryTemp = iRepertoryDao.delRepertoryData(id);
        int goodsTemp = iGoodsDao.delGoods(id);
        return goodsTemp + repertoryTemp;
    }

    //根据单价来查询
    @Transactional
    public List<Goods> findByGoodsPrice(Paging paging) {
        List<Goods> list = iGoodsDao.findByPrice(paging);
        Repertory repertory = new Repertory();
        for (Goods lt : list
                ) {
            repertory.setNumber(iRepertoryDao.findNumberById(lt.getId()));
            lt.setRepertory(repertory);
        }
        return list;
    }

    //修改admin的级别也是间接添加管理员
    @Transactional
    public String alterAdminClasses(Admin admin, int oneselfClasses, int classes) {
        if (oneselfClasses >= classes && admin.getClasses() <= oneselfClasses) {
            System.out.println(oneselfClasses + "," + classes);
            //进行修改
            if (iAdminDao.alterAdmin(admin) != 0) {
                System.out.println("yes");
                return "修改成功";
            }
        }
        return "你的级别不够";
    }

    //通过管理员的等级条件来查询
    @Transactional
    public List<UserInfo> findByAdminClasses(Paging paging, int classes) {
        paging.setClasses(classes);
        List<Admin> adminList = iAdminDao.findByClasses(paging);
        List<UserInfo> userInfoList =new ArrayList<UserInfo>();
        List<User> userList =new ArrayList<User>();
        //查询用户基本信息
        for (Admin list:adminList
             ) {
            //查询用户基本信息
            userInfoList.add(iUserInfoDao.findUserInfoById(list.getId()));
            //查询用户账号
            userList.add(iUserDao.findUserById(list.getId()));
        }
        //整合返回页面展示
        for (int i = 0; i < userInfoList.size(); i++) {
                //添加user用户信息
                userInfoList.get(i).setUser(userList.get(i));
                //颜色
                userInfoList.get(i).setColor(i + 1);
                //管理级别
                userInfoList.get(i).setClasses(adminList.get(i).getClasses());
            }
        return userInfoList;
    }

    //通过账号来模糊查询用户信息
    @Transactional
    public List<UserInfo> findAllByLikeName(Paging paging) {
        List<User> listUser = iUserDao.findByLikeName(paging);
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        //利用找到的用户，查找用户基本信息
        for (User lt:listUser
             ) {
            userInfoList.add(iUserInfoDao.findUserInfoById(lt.getId()));
        }
        //添加用户信息以及颜色
        for (int i = 0; i <userInfoList.size() ; i++) {
                userInfoList.get(i).setColor(i+1);
                userInfoList.get(i).setUser(listUser.get(i));
        }
        return userInfoList;
    }

//    查找数据库里所有的管理员
    @Transactional
    public int countAdminnumber() {
       return iAdminDao.countAdminnumber();
    }

//    查询级别等于classes的数据总数量
    @Transactional
    public int findSumNumberByClasses(Paging paging){
        return iAdminDao.findSumNumberByClasses(paging);
    }

}

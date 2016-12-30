package com.starlight.serviceimp;

import com.starlight.dao.*;
import com.starlight.entity.*;
import com.starlight.dao.IAdminDao;
import com.starlight.entity.Admin;
import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Service
@Transactional
public class AdminServiceImp implements IAdminService {

    @Resource
    List<Goods> list;
    @Resource
    AdminServiceImp adminServiceImp;

    @Resource
    IAdminDao iAdminDao;

    @Resource
    IUserInfoDao iUserInfoDao;

    @Resource
    IUserDao iUserDao;

    @Resource
    IChangePasswordDao iChangePasswordDao;

    @Resource
    IOpinionDao iOpinionDao;

    @Resource
    IOrderDao iOrderDao;

    @Resource
    IShoppingCartDao iShoppingCartDao;

    @Resource
    IWalletDao iWalletDao;

    @Resource
    Paging paging;

    @Resource
    IGoodsDao iGoodsDao;

    @Resource
    IRepertoryDao iRepertoryDao;

    public void addAdmin(Admin admin) {
        iAdminDao.addAdmin(admin);
    }
    //查询管理员的等级
    public int findClassesById(int u_id) {
        return iAdminDao .findClassesById(u_id);

    }

    //删除用户所有数据的操作
    public int delAllUserData(int uid) {
        int uftemp = 0, cls = 0, wle = 0, on = 0, pwp = 0, shopping = 0, os = 0, user = 0;
        try {
            //用户信息
            uftemp = iUserInfoDao.delUserInfo(uid);
            //钱包
            wle = iWalletDao.delWakket(uid);
   /*         //购物车
            shopping = iShoppingCartDao.delShoppingCart(uid);*/
   /*         //意见
            on = iOpinionDao.delOpinion(uid);*/
      /*      //订单
            os = iOrderDao.delOrder(uid);*/
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
    public List<Goods> findAllByPaging(Paging paging) {
        //赋值，进行页面展示
        return iGoodsDao.byPagingfindAll(paging);
    }

    //查询数据总数量
    public int conutGoodsDataNumber() {
        return iGoodsDao.conutGoodsNumber();
    }


    //根据分页的页码来展示数据
    public List<Goods> pagination(String pagination, String number) {
        //页面的数据数量
        int nbr = Integer.parseInt(number.substring(number.indexOf(":") + 1, number.length()));
        //页码
        int pat = Integer.parseInt(pagination);
        //从第几个数据开始
        paging.setRise(pat * nbr - nbr);
        //那个数据结束
        paging.setStop(pat * nbr);
        return iGoodsDao.byPagingfindAll(paging);
    }

    //查询有关管理员的信息
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
    public int alterGoodsData(Goods goods, Repertory repertory) {
        int goodsTemp = iGoodsDao.alterGoods(goods);
        int repertoryTemp = iRepertoryDao.alterRepertory(repertory);
        return goodsTemp + repertoryTemp;
    }

    //删除商品信息
    public int delGoodsData(int id) {
        int repertoryTemp = iRepertoryDao.delRepertoryData(id);
        int goodsTemp = iGoodsDao.delGoods(id);
        return goodsTemp + repertoryTemp;
    }

    //根据单价来查询
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
}

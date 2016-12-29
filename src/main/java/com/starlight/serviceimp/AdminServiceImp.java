package com.starlight.serviceimp;

import com.starlight.dao.*;
import com.starlight.entity.Admin;
import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.entity.UserInfo;
import com.starlight.service.IAdminService;
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
public class AdminServiceImp implements IAdminService {

    @Resource
    List<Goods> list;
    @Resource
    IAdminDao iAdminDao;

    @Resource
    AdminServiceImp adminServiceImp;

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

    public void addAdmin(Admin admin) {
            iAdminDao.addAdmin(admin);
    }

    //查询管理员的等级
    public int findClassesById(int u_id) {
        return iAdminDao.findClassesById(u_id);
    }

    //删除用户所有数据的操作
    public int delAllUserData(int uid) {
        int uftemp = 0, cls = 0, wle = 0, on = 0, pwp = 0, shopping = 0, os = 0, user = 0;
        try {
            //用户信息
            uftemp = iUserInfoDao.delUserInfo(uid);
            //钱包
            wle = iWalletDao.delWakket(uid);
            //购物车
            shopping = iShoppingCartDao.delShoppingCart(uid);
            //意见
            on = iOpinionDao.delOpinion(uid);
            //订单
            os = iOrderDao.delOrder(uid);
            //密保
            pwp = iChangePasswordDao.deletePwp(uid);
            //管理员
            cls = iAdminDao.delAllUserData(uid);
        } catch (Exception e) {
            //用户
            user = iUserDao.delUser(uid);
        }
        if (cls != 0 || wle != 0 || on != 0 || pwp != 0 ||
                shopping != 0 || os != 0 || user != 0 || uftemp != 0) {
            return 1;
        }
        return 0;
    }

    //查询商品
    public List<Goods> findAllByPaging(Paging paging) {
        //赋值，进行页面展示
        return Appliction.getAct().getBean(IGoodsDao.class).byPagingfindAll(paging);
    }

    //查询数据总数量
    public int conutGoodsDataNumber() {
        return Appliction.getAct().getBean(IGoodsDao.class).conutGoodsNumber();
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
        return Appliction.getAct().getBean(IGoodsDao.class).byPagingfindAll(paging);
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
}

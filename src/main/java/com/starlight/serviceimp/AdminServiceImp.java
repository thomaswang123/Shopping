package com.starlight.serviceimp;

import com.starlight.dao.IAdminDao;
import com.starlight.entity.Admin;
import com.starlight.service.IAdminService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Service
@Transactional
public class AdminServiceImp implements IAdminService {
     
    @Resource
    IAdminDao iAdminDao;
    
    //查询管理员的等级
    public int finAllClssesById(int u_id) {
        return Appliction.getAct().getBean(IAdminDao.class).finAllClssesById(u_id);
    }

    public void addAdmin(Admin admin) {
        iAdminDao.addAdmin(admin);
    }
}

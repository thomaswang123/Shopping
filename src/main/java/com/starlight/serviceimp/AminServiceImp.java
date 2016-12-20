package com.starlight.serviceimp;

import com.starlight.dao.AdminDao;
import com.starlight.service.AdminService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public class AminServiceImp implements AdminService{

    //查询管理员的等级
    public int finAllClssesById(int u_id) {
        return Appliction.getAct().getBean(AdminDao.class).finAllClssesById(u_id);
    }
}

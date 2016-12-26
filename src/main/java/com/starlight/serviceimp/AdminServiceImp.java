package com.starlight.serviceimp;

import com.starlight.dao.IAdminDao;
import com.starlight.service.IAdminService;
import com.starlight.util.Appliction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public class AdminServiceImp implements IAdminService {
     
    @Resource
    IAdminDao iAdminDao;
    
    //查询管理员的等级
    public int findAllClssesById(int u_id) {
       if(Appliction.getAct().getBean(IAdminDao.class).findAllClssesById(u_id)+""==null){
            return 0;
        }
      return  Appliction.getAct().getBean(IAdminDao.class).findAllClssesById(u_id);
    }
    
     
    
}

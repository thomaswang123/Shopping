package com.starlight.serviceimp;

import com.starlight.dao.IAdminDao;
import com.starlight.entity.Admin;
import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/28.
 */
@Service
@Transactional
public class AdminServiceImp implements IAdminService {
    @Resource
    List<Goods> list;
    @Resource
    IAdminDao iAdminDao;
    public int finAllClassesById(int u_id) {
        return iAdminDao.finAllClassesById(u_id);
    }

    public void addAdmin(Admin admin) {
            iAdminDao.addAdmin(admin);
    }

    public int delAllUserData(int uid) {
        return 0;
    }

    public List<Goods> findAllByPaging(Paging paging) {
        return null;
    }

    public int conutGoodsDataNumber() {
        return 0;
    }

    public List<Goods> pagination(String pagination, String number) {
        return null;
    }
}

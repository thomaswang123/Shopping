package com.starlight.serviceimp;

import com.starlight.dao.IRepertoryDao;
import com.starlight.entity.Repertory;
import com.starlight.service.IRepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by james.jiang on 2016/12/29.
 * 库存表
 */
@Service
public class RepertoryServiceImp implements IRepertoryService{
    @Autowired
    private IRepertoryDao iRepertoryDao;
//   添加库存
    @Transactional
    public void addRepertory(Repertory repertory) {
        iRepertoryDao.addRepertory(repertory);
    }
}

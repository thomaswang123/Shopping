package com.starlight.serviceimp;

import com.starlight.dao.IRepertoryDao;
import com.starlight.entity.Repertory;
import com.starlight.service.IRepertoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by james.jiang on 2016/12/29.
 * 库存表
 */
@Service
@Transactional
public class RepertoryServiceImp implements IRepertoryService{
    @Resource
    private IRepertoryDao iRepertoryDao;
//   添加库存
    public void addRepertory(Repertory repertory) {
        iRepertoryDao.addRepertory(repertory);
    }
}

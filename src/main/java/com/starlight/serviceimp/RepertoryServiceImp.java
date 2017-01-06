package com.starlight.serviceimp;

import com.starlight.dao.IRepertoryDao;
import com.starlight.entity.Repertory;
import com.starlight.service.IRepertoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by james.jiang on 2016/12/29.
 * 库存业务类
 */
@Service
public class RepertoryServiceImp implements IRepertoryService{

    /**库存sql接口*/
    @Resource
    private IRepertoryDao iRepertoryDao;

    /**
     * 添加库存信息
     * @param repertory 库存
     */
    @Transactional
    public void addRepertory(Repertory repertory) {
        iRepertoryDao.addRepertory(repertory);
    }
}

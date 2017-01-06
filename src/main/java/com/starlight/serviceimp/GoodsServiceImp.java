package com.starlight.serviceimp;

import com.starlight.dao.IGoodsDao;
import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
@Service
public class GoodsServiceImp implements IGoodsService {
    @Autowired
    private IGoodsDao iGoodsDao;

//   查找商品
    @Transactional
    public List<Goods> findAll() {
        return iGoodsDao.findAll();
    }

//   通过ID查找商品
    @Transactional
    public Goods findById(int id) {
        return iGoodsDao.findById(id);
    }
//  添加商品
    @Transactional
    public void addGoods(Goods goods) {
        iGoodsDao.addGoods(goods);
    }
    @Transactional
    public int findMaxId() {
        return iGoodsDao.findMaxId();
    }
    @Transactional
    public int findSumNumberByPrice(Paging paging) {
        return iGoodsDao.findSumNumberByPrice(paging);
    }
}

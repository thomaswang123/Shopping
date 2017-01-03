package com.starlight.serviceimp;

import com.starlight.dao.IGoodsDao;
import com.starlight.entity.Goods;
import com.starlight.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
@Service
@Transactional
public class GoodsServiceImp implements IGoodsService {
    @Resource
    private IGoodsDao iGoodsDao;

//   查找商品
    public List<Goods> findAll() {
        return iGoodsDao.findAll();
    }

//   通过ID查找商品
    public Goods findById(int id) {
        return iGoodsDao.findById(id);
    }
//  添加商品
    public void addGoods(Goods goods) {
        iGoodsDao.addGoods(goods);
    }
}

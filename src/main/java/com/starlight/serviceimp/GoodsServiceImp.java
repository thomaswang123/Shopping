package com.starlight.serviceimp;

import com.starlight.dao.IGoodsDao;
import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 * 产品业务类
 */
@Service
public class GoodsServiceImp implements IGoodsService {

    /**商品sql接口*/
    @Resource
    private IGoodsDao iGoodsDao;

    /**
     * 查找商品
     * @return
     */
    @Transactional
    public List<Goods> findAll() {
        return iGoodsDao.findAll();
    }

    /**
     * 通过ID查找商品
     * @param id
     * @return
     */
    @Transactional
    public Goods findById(int id) {
        return iGoodsDao.findById(id);
    }

    /**
     * 添加商品
     * @param goods
     */
    @Transactional
    public void addGoods(Goods goods) {
        iGoodsDao.addGoods(goods);
    }

    /**
     *
     * @return
     */
    @Transactional
    public int findMaxId() {
        return iGoodsDao.findMaxId();
    }

    /**
     *
     * @param paging
     * @return
     */
    @Transactional
    public int findSumNumberByPrice(Paging paging) {
        return iGoodsDao.findSumNumberByPrice(paging);
    }
}

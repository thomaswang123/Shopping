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
     * @return  商品集合
     */
    @Transactional
    public List<Goods> findAll() {
        return iGoodsDao.findAll();
    }

    /**
     * 通过ID查找商品
     * @param id    商品id
     * @return  一条商品数据
     */
    @Transactional
    public Goods findById(int id) {
        return iGoodsDao.findById(id);
    }

    /**
     * 添加商品
     * @param goods 一条商品数据
     */
    @Transactional
    public void addGoods(Goods goods) {
        iGoodsDao.addGoods(goods);
    }

    /**
     *查找最大的ID
     * @return  返回id
     */
    @Transactional
    public int findMaxId() {
        return iGoodsDao.findMaxId();
    }

    /**
     *通过价格查找商品
     * @param paging 分页
     * @return  数量
     */
    @Transactional
    public int findSumNumberByPrice(Paging paging) {
        return iGoodsDao.findSumNumberByPrice(paging);
    }
}

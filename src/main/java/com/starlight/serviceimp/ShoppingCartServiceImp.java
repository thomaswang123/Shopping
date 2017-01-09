package com.starlight.serviceimp;

import com.starlight.dao.IShoppingCartDao;
import com.starlight.entity.ShoppingCart;
import com.starlight.service.IShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2017/1/9.
 * 购物车业务实现类
 */
@Service
public class ShoppingCartServiceImp implements IShoppingCartService{

    /**购物车sql接口*/
    @Resource
    private IShoppingCartDao iShoppingCartDao;

    /**
     * 通过用户id购物车里所有的商品
     * @param id    用户id
     * @return  商品集合
     */
    @Transactional
    public List<ShoppingCart> findById(int id) {
        return iShoppingCartDao.findAll(id);
    }

    /**
     * 添加数据到购物车
     * @param shoppingCart  一条购物车信息
     */
    public void addToCart(ShoppingCart shoppingCart) {
        iShoppingCartDao.addToCart(shoppingCart);
    }

    /**
     * 通过商品id删除指定的商品信息
     * @param id    商品id
     */
    public void removeOfCart(int id) {
        iShoppingCartDao.removeOfCart(id);
    }

    /**
     * 通过id查找指定的商品
     * @param id    商品id
     * @return  一条购物车信息
     */
    public ShoppingCart findOnlyOne(int id) {
        return iShoppingCartDao.findOnlyOne(id);
    }
}

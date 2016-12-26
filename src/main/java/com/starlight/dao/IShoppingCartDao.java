package com.starlight.dao;

import com.starlight.entity.ShoppingCart;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/21.
 * 购物车DAO
 */

public interface IShoppingCartDao {
	/**
	 * 通过用户ID查找购物车内所有的商品
	 * @return
	 */
	List<ShoppingCart> findAll(int id);

	/**
	 * 插入一条数据
	 * @param shoppingCart
	 */
	void addToCart(ShoppingCart shoppingCart);

}

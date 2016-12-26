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

	/**
	 * 删除用户信息
	 * @param uid
	 * @return
	 */
	int delShoppingCart(int uid);
	/**
	 * 通过Id删除一条数据
	 * @param id
	 */
	void removeOfCart(int id);

	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	ShoppingCart findOnlyOne(int id);

}

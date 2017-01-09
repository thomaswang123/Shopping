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
	 * @return	购物车信息集合
	 */
	List<ShoppingCart> findAll(int id);

	/**
	 * 插入一条数据
	 * @param shoppingCart	购物车信息
	 */
	void addToCart(ShoppingCart shoppingCart);

	/**
	 * 通过Id删除一条数据
	 * @param id	购物车id
	 */
	void removeOfCart(int id);

	/**
	 * 通过ID查找一条数据
	 * @return	一条购物车信息
	 * @param id	购物车id
	 */
	ShoppingCart findOnlyOne(int id);


}

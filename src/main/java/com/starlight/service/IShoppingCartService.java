package com.starlight.service;

import com.starlight.entity.ShoppingCart;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 * 购物车业务
 */
public interface IShoppingCartService {
	/**
	 * 通过用户id购物车里所有的商品
	 * @param id    用户id
	 * @return  商品集合
	 */
	List<ShoppingCart> findById(int id);

	/**
	 * 添加数据到购物车
	 * @param shoppingCart  一条购物车信息
	 */
	void addToCart(ShoppingCart shoppingCart);

	/**
	 * 通过商品id删除指定的商品信息
	 * @param id    商品id
	 */
	void removeOfCart(int id);

	/**
	 * 通过id查找指定的商品
	 * @param id    商品id
	 * @return  一条购物车信息
	 */
	ShoppingCart findOnlyOne(int id);


}

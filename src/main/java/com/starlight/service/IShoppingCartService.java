package com.starlight.service;

import com.starlight.entity.ShoppingCart;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
public interface IShoppingCartService {
	/**
	 * 查找某个用户的购物车的所有数据
	 * @param id
	 * @return
	 */
	List<ShoppingCart> findById(int id);

	/**
	 * 添加商品到购物车
	 * @param shoppingCart
	 */
	void addToCart(ShoppingCart shoppingCart);

	/**
	 * 删除购物车中的一条数据
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

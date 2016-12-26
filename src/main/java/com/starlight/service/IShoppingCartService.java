package com.starlight.service;

import com.starlight.entity.ShoppingCart;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
public interface IShoppingCartService {
	/**
	 * 查找某个用户的购物车
	 * @param id
	 * @return
	 */
	List<ShoppingCart> findById(int id);

	/**
	 * 添加商品到购物车
	 * @param shoppingCart
	 */
	void addToCart(ShoppingCart shoppingCart);
}

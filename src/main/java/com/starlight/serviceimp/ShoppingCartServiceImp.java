package com.starlight.serviceimp;

import com.starlight.dao.IShoppingCartDao;
import com.starlight.entity.ShoppingCart;
import com.starlight.service.IShoppingCartService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
@Component
public class ShoppingCartServiceImp implements IShoppingCartService {
	@Resource
	IShoppingCartDao iShoppingCartDao;
	public List<ShoppingCart> findById(int id) {
		return iShoppingCartDao.findAll(id);
	}

	public void addToCart(ShoppingCart shoppingCart){
		iShoppingCartDao.addToCart(shoppingCart);
	}



}

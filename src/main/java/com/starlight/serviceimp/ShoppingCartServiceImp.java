package com.starlight.serviceimp;

import com.starlight.dao.IShoppingCartDao;
import com.starlight.entity.ShoppingCart;
import com.starlight.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
@Service
public class ShoppingCartServiceImp implements IShoppingCartService {
	@Autowired
	private IShoppingCartDao iShoppingCartDao;
	@Transactional
	public List<ShoppingCart> findById(int id) {
		return iShoppingCartDao.findAll(id);
	}
	@Transactional
	public void addToCart(ShoppingCart shoppingCart){
		iShoppingCartDao.addToCart(shoppingCart);
	}
	@Transactional
 	public void removeOfCart(int id){
			iShoppingCartDao.removeOfCart(id);
	}
	@Transactional
	public ShoppingCart findOnlyOne(int id){

		return iShoppingCartDao.findOnlyOne(id);
	}


}

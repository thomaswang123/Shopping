package com.starlight.dao;

import com.starlight.entity.Goods;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */

public interface IGoodsDao {
	/**
	 * 查询所有
	 * @return
	 */
	List<Goods> findAll();

	/**
	 * 通过ID查找商品
	 * @param id
	 * @return
	 */
	Goods findById(int id);


}

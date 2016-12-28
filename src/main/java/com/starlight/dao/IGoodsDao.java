package com.starlight.dao;

import com.starlight.entity.Goods;
import com.starlight.entity.Paging;

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

	/**
	 * 通过分页查询商品信息
	 * @param paging
	 * @return
	 */
	List<Goods> byPagingfindAll(Paging paging);

	/**
	 * 统计数量
	 * @return
	 */
	int conutGoodsNumber();
}

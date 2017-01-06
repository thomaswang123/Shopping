package com.starlight.service;

import com.starlight.entity.Goods;
import com.starlight.entity.Paging;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 */
public interface IGoodsService {
	/**
	 * 查找所有的商品信息
	 * @return
	 */
	List<Goods> findAll();

	/**
	 * 通过Id查找商品
	 * @param id
	 * @return
	 */
	Goods findById(int id);

	/**
	 * 添加商品
	 * @param goods
	 */
	void addGoods(Goods goods);

	/**
	 * 求最大id值
	 * @return
	 */
	int findMaxId();

	/**
	 * 根据单价查询数据的总数量
	 * @param paging
	 */
	int  findSumNumberByPrice(Paging paging);
}

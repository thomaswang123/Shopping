package com.starlight.service;

import com.starlight.entity.Goods;
import com.starlight.entity.Paging;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 * 商品业务
 */
public interface IGoodsService {
	/**
	 * 查找商品
	 * @return  商品集合
	 */
	List<Goods> findAll();

	/**
	 * 通过ID查找商品
	 * @param id    商品id
	 * @return  一条商品数据
	 */
	Goods findById(int id);

	/**
	 * 添加商品
	 * @param goods 一条商品数据
	 */
	void addGoods(Goods goods);

	/**
	 *查找最大的ID
	 * @return  返回id
	 */
	int findMaxId();

	/**
	 *通过价格查找商品
	 * @param paging 分页
	 * @return  数量
	 */
	int  findSumNumberByPrice(Paging paging);
}

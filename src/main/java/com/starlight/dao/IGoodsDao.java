package com.starlight.dao;

import com.starlight.entity.Goods;
import com.starlight.entity.Paging;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 * 商品接口
 */

public interface IGoodsDao {
	/**
	 * 查询所有
	 * @return	商品集合
	 */
	List<Goods> findAll();

	/**
	 * 求最大id值
	 * @return	id
	 */
	int findMaxId();
	/**
	 * 通过ID查找商品
	 * @param id	商品id
	 * @return	一条商品信息
	 */
	Goods findById(int id);

	/**
	 * 通过分页查询商品信息
	 * @param paging	分页
	 * @return	商品集合
	 */
	List<Goods> byPagingfindAll(Paging paging);

	/**
	 * 统计数量
	 * @return	商品集合
	 */
	int conutGoodsNumber();

	/**
	 * 修改商品信息
	 * @param goods		一条商品信息
	 * @return	提示信息
	 */
	int alterGoods(Goods goods);

	/**
	 * 删除商品的信息
	 * @param id	商品id
	 */
	 int delGoods(int id);

	/**
	 * 根据单价查询
	 * @param paging	分页
	 * @return	商品集合
	 */
	List<Goods> findByPrice(Paging paging);

	/**
	 * 根据单价查询数据的总数量
	 * @param paging	分页
	 */
	int  findSumNumberByPrice(Paging paging);


	/**
	 * 添加商品
	 * @param goods		一条商品信息
	 */
	void addGoods(Goods goods);
}

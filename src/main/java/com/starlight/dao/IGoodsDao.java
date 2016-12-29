package com.starlight.dao;

import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.entity.Repertory;

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
	 * 求最大id值
	 * @return
	 */
	int findMaxId();
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

	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	int alterGoods(Goods goods);

	/**
	 * 删除商品的信息
	 * @param id
	 */
	 int delGoods(int id);

	/**
	 * 根据单价查询
	 * @param paging
	 * @return
	 */
	List<Goods> findByPrice(Paging paging);

	/**
	 * 根据单价查询数据的总数量
	 * @param paging
	 */
	int  findSumNumberByPrice(Paging paging);

}

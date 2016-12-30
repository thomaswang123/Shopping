package com.starlight.dao;

import com.starlight.entity.Repertory;

/**
 * Created by james.jiang on 2016/12/20.
 * 库存sql接口
 */

public interface IRepertoryDao {

	/**
	 *  查询库存
	 * @param id
	 * @return
	 */
	int findNumberById(int id);

	/**
	 * 添加库存
	 * @param repertory
	 * @return
	 */
	boolean addRepertory(Repertory repertory);

	/**
	 *  减少库存
	 * @param re
	 * @return
	 */
	boolean cutRepertory(Repertory re);

	/**
	 * 修改商品的库存信息
	 * @param repertory
	 * @return
	 */
	int alterRepertory(Repertory repertory);

	/**
	 * 删除商品的库存信息
	 * @param id
	 * @return
	 */
	int delRepertoryData(int id);

}

package com.starlight.dao;

import com.starlight.entity.Repertory;

/**
 * Created by james.jiang on 2016/12/20.
 * 库存sql接口
 */

public interface IRepertoryDao {

	/**
	 *  查询库存
	 * @param id	商品id
	 * @return	库存量
	 */
	int findNumberById(int id);

	/**
	 * 添加库存
	 * @param repertory	库存
	 */
	void addRepertory(Repertory repertory);


	/**
	 * 修改商品的库存信息
	 * @param repertory		库存
	 * @return	提示信息
	 */
	int alterRepertory(Repertory repertory);

	/**
	 * 删除商品的库存信息
	 * @param id	库存id
	 * @return	提示信息
	 */
	int delRepertoryData(int id);

}

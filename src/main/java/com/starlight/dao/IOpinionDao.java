package com.starlight.dao;

import com.starlight.entity.Opinion;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/21.
 *意见sql接口
 */
public interface IOpinionDao {

    /**
     * 查找指定的评论
     * @param id    商品id
     * @return  意见集合
     */
    List<Opinion> findGoodsOpinion(int id);
}

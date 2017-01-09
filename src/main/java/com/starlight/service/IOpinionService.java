package com.starlight.service;

import com.starlight.entity.Opinion;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/28.
 * 商品意见业务
 */
public interface IOpinionService {
    /**
     * 查找商品
     * @param id  商品id
     * @return  意见集合
     */
    List<Opinion> findGoodsOpinion(int id);
}

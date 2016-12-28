package com.starlight.service;

import com.starlight.entity.Opinion;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/28.
 */
public interface IOpinionService {
    /**
     * 查找指定商品的评论
     * @param id
     * @return
     */
    List<Opinion> findGoodsOpinion(int id);
}

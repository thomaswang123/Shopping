package com.starlight.dao;

import com.starlight.entity.Opinion;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/21.
 */
public interface IOpinionDao {

    /**
     * 查找指定的评论
     * @param id
     * @return
     */
    List<Opinion> findGoodsOpinion(int id);
}

package com.starlight.service;

import com.starlight.entity.Repertory;

/**
 * Created by james.jiang on 2016/12/29.
 * 库存业务
 */
public interface IRepertoryService {
    /**
     * 添加库存信息
     * @param repertory 库存
     */
    void addRepertory(Repertory repertory);
}

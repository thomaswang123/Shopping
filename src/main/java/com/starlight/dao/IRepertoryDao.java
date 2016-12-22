package com.starlight.dao;

import com.starlight.entity.Repertory;
import org.springframework.stereotype.Component;

/**
 * Created by james.jiang on 2016/12/20.
 * 库存sql接口
 */
@Component
public interface IRepertoryDao {
//	    查询库存
	Repertory findById(int id);
//	    添加库存
	boolean addRepertory(Repertory re);
//	    减少库存
	boolean cutRepertory(Repertory re);
}

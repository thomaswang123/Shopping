package com.starlight.serviceimp;

import com.starlight.dao.IOpinionDao;
import com.starlight.entity.Opinion;
import com.starlight.service.IOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by james.jiang on 2016/12/28.
 */
@Service
public class OpinionServiceImp implements IOpinionService {
    @Autowired
    private IOpinionDao iOpinionDao;
    @Transactional
    public List<Opinion> findGoodsOpinion(int goodsId) {
        return iOpinionDao.findGoodsOpinion(goodsId);
    }
}

package com.starlight.serviceimp;

import com.starlight.dao.IOpinionDao;
import com.starlight.entity.Opinion;
import com.starlight.service.IOpinionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/28.
 */
@Service
@Transactional
public class OpinionServiceImp implements IOpinionService {
    @Resource
    private IOpinionDao iOpinionDao;
    public List<Opinion> findGoodsOpinion(int goodsId) {
        return iOpinionDao.findGoodsOpinion(goodsId);
    }
}

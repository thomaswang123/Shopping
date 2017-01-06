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
 * 意见业务类
 */
@Service
public class OpinionServiceImp implements IOpinionService {

    /**商品意见sql接口*/
    @Resource
    private IOpinionDao iOpinionDao;

    /**
     * 查找商品
     * @param goodsId
     * @return
     */
    @Transactional
    public List<Opinion> findGoodsOpinion(int goodsId) {
        return iOpinionDao.findGoodsOpinion(goodsId);
    }
}

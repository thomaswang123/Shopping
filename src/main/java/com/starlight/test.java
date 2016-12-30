package com.starlight;

import com.starlight.dao.IUserInfoDao;
import com.starlight.entity.Paging;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by thomas.wang on 2016/12/30.
 */
public class test {
    @Resource
    IUserInfoDao iUserInfoDao ;

    @Test
    public void test(){
        Paging paging = new Paging();
        paging.setRise(10);
        paging.setStop(20);
   /*     System.out.println(iUserInfoDao.byPagingfindAll(paging)); */
        System.out.println(iUserInfoDao);
    }
}

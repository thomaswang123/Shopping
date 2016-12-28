package com.starlight.service;

import com.starlight.entity.User;
import com.starlight.entity.Wallet;

/**
 * Created by thomas.wang on 2016/12/21.
 */
public interface IChangePasswordService {
    /**
     * 通过id查询密保以及id
     * @param u_id
     * @return
     */
   String findQuestionAndIddByUid(int u_id);

    /**
     * 通过u_id查询答案，进行判断比对是否相同
     * @param u_id
     * @return
     */
      String Answer_Comparison(String[] result,int u_id);

    /**
     * 通过u_id进行不同数据库操作！这里需要事务处理
     * @param user   用户对象
     * @param wallet    用户钱包对象
     * @param result  密保答案
     */
     String alertAllById(User user,String[] result,String[] ppid,Wallet wallet);



}

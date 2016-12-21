package com.starlight.service;

import com.starlight.entity.PasswordProtecTion;

import java.util.List;
import java.util.Map;

/**
 * Created by thomas.wang on 2016/12/21.
 */
public interface Change_PasswordService {
    /**
     * 通过id查询密保
     * @param u_id
     * @return
     */
    public String findQuestionById(int u_id);

    /**
     * 通过u_id查询答案，进行判断比对是否相同
     * @param u_id
     * @return
     */
    public  String Answer_Comparison(int u_id,String[] result);

    /**
     * 通过u_id进行不同数据库操作！这里需要事务处理
     * @param u_id  用户的id
     * @param paypwd   用户支付密码
     * @param pwd     用户密码
     * @param result  密保答案
     */
    public String alertAllById(int u_id,String pwd,String paypwd,String[] result);
}

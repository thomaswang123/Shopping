package com.starlight.dao;

import com.starlight.entity.PasswordProtection;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */
@Component
public interface IChangePasswordDao {

    /**
     * 通过id查询密保与密保问题进行判断是否一致
     * @param u_id
     * @return
     */
     List<PasswordProtection> findQuestionAndIddByUid(int u_id);

    /**
     * 通过u_id查询答案，进行判断是否相同
     * @param u_id
     * @return
     */
    List<PasswordProtection> findAnswerById(int u_id);
}

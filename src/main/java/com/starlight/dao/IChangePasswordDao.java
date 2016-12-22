package com.starlight.dao;

import com.starlight.entity.PassWordProtection;
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
     List<PassWordProtection> findQuestionAndIddByUid(int u_id);

    /**
     * 通过u_id查询答案，进行判断是否相同
     * @param u_id
     * @return
     */
    List<PassWordProtection> findAnswerById(int u_id);

//	查询密保
List<PassWordProtection> findAllById(int id);
//	删除密保
void deleteById(int id);
//	添加密保
void addPWP(PassWordProtection passWordProtection);
//	修改密保
void alterPWP(PassWordProtection passWordProtection);
}

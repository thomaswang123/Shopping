package com.starlight.dao;

import com.starlight.entity.PassWordProtection;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 */

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
    String[] findAnswerById(int u_id);


	/**
	 * 删除密保
	 * @param id
	 */
	int deletePwp(int id);

	/**
	 * 添加密保
	 * @param passWordProtection
	 */
	void addPWP(PassWordProtection passWordProtection);

	/**
	 *修改密保
	 * * @param list
    */
	int alterPWP(PassWordProtection pwp);
}

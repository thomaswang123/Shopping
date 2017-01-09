package com.starlight.dao;

import com.starlight.entity.PassWordProtection;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 密保sql操作
 */

public interface IChangePasswordDao {

    /**
     * 通过id查询密保与密保问题进行判断是否一致
     * @param userId	用户id
     * @return	集合密保
     */
     List<PassWordProtection> findQuestionAndIddByUid(int userId);

    /**
     * 通过u_id查询答案，进行判断是否相同
     * @param userId	用户id
     * @return	密保答案集合
     */
    String[] findAnswerById(int userId);


	/**
	 * 删除密保
	 * @param id	密保id
	 */
	int deletePwp(int id);

	/**
	 * 添加密保
	 * @param passWordProtection	密保
	 */
	void addPWP(PassWordProtection passWordProtection);

	/**
	 * 修改密保
	 * @param pwp	密保
	 * @return	提示信息
	 */
	int alterPWP(PassWordProtection pwp);
}

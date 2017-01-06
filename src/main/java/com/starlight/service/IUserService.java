package com.starlight.service;

import com.starlight.entity.Paging;
import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 *   用户接口
 */

public interface IUserService {

	/**
	 * 用户登陆
	 * @param user  用户账号密码
	 * @return  查找数据返回数量
	 */
	 int login(User user);

	/**
	 * 根据用户账号来查询id，用于判断账号是否存在
	 * @param username 用户账号
	 * @return  返回0或者非0数
	 */
	 int   bynameGainId(String username);


	/**
	 * 用户注册
	 * @param user  用户
	 * @return  如果插入成功返回非0数，插入失败则反之
	 */
	int register(User user);

	/**
	 * 添加密保
	 * @param passWordProtection    密保对象
	 */
	void addPWP(PassWordProtection passWordProtection);

	/**
	 * 通过账号查找是否存在该用户
	 * @param account   账号
	 * @return  用户集合
	 */
	List<User> findAccount(String account);

	/**
	 * 通过ID查找用户账号
	 * @param userId   用户
	 * @return  用户
	 */
	User findAccountById(int userId);

	/**
	 * 根据账号条件来模糊查询的总数量
	 * @param paging   分页对象
	 * @return  分页数
	 */
	int findByLikeNameNumber(Paging paging);

}

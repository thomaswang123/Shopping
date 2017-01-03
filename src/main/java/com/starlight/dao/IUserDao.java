package com.starlight.dao;

import com.starlight.entity.Paging;
import com.starlight.entity.User;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */

public interface IUserDao {
	/**
	 * 查找所有的用户
	 * @return list
	 */
	List<User> findAll();

	/**
	 * 判断用户是否存在
	 * @param user 账号
	 * @return boolean
	 */
	 int login(User user);

	/**
	 * 通过账号来查询id
	 * @return   id
	 */
	 int findIdByAccounUnmber(String username);

	/**
	 * 用来修改用户密码
	 * @param user  用户的id
	 * @return
	 */
	 int alertPwdById(User user);

	/**
	 * 统计所有的用户的数量
	 * @return
	 */
	  int countAllIdNumber();

	/**
	 *  用户注册
	 * @param user
	 */
	void register(User user);

    /**
     * 查找该用户id
     * @param account
     * @return
     */
    int findIdByUser(String account);

	/**
	 * 查询账号是否存在
	 * @param account
	 * @return
	 */
	List<User> findAccount(String account);


	/**
	 * 通过ID查找账号
	 * @param id
	 * @return
	 */
	User findAccountById(int id);

	/**
	 * 删除用户信息
	 * @param uid
	 * @return
	 */
	int delUser(int uid);

	/**
	 * 查询出管理员
	 * @param paging
	 * @return
	 */
	List<User> findAllUserByPaging(Paging paging);

	/**
	 * 查询用户的账号加id信息
	 * @param uid
	 * @return
	 */
	User  findUserById(int uid);

	/**
	 * 根据账号条件来模糊查询
	 * @param paging
	 * @return
	 */
	List<User> findByLikeName(Paging paging);

	/**
	 * 根据账号条件来模糊查询的总数量
	 * @param paging
	 * @return
	 */
	int findByLikeNameNumber(Paging paging);
}

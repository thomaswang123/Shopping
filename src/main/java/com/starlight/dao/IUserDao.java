package com.starlight.dao;

import com.starlight.entity.Paging;
import com.starlight.entity.User;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 * 用户sql接口
 */

public interface IUserDao {

	/**
	 * 查找所有的用户
	 * @return list		用户集合
	 */
	List<User> findAll();

	/**
	 * 判断用户是否存在
	 * @param user 账号
	 * @return 提示信息
	 */
	 int login(User user);

	/**
	 * 通过账号来查询id
	 * @return   用户id
	 */
	 int findIdByAccounUnmber(String username);

	/**
	 * 用来修改用户密码
	 * @param user  用户
	 * @return	提示信息
	 */
	 int alertPwdById(User user);

	/**
	 * 统计所有的用户的数量
	 * @return	用户数量
	 */
	  int countAllIdNumber();

	/**
	 *  用户注册
	 * @param user	一条用数据
	 */
	void register(User user);

    /**
     * 查找该用户id
     * @param account	账号
     * @return	用户id
     */
    int findIdByUser(String account);

	/**
	 * 查询账号是否存在
	 * @param account	账号
	 * @return	用户集合
	 */
	List<User> findAccount(String account);

	/**
	 * 通过ID查找账号
	 * @param id	用id
	 * @return	一条用户信息
	 */
	User findAccountById(int id);

	/**
	 * 删除用户信息
	 * @param uid	用户id
	 * @return	提示信息
	 */
	int delUser(int uid);

	/**
	 * 查询用户的账号加id信息
	 * @param uid	用户id
	 * @return	用户
	 */
	User  findUserById(int uid);

	/**
	 * 根据账号条件来模糊查询
	 * @param paging	分页
	 * @return	用户信息集合
	 */
	List<User> findByLikeName(Paging paging);

	/**
	 * 根据账号条件来模糊查询的总数量
	 * @param paging	分页
	 * @return	数据量
	 */
	int findByLikeNameNumber(Paging paging);
}

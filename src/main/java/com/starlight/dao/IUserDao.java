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
	 int findIdByAccoun_Unmber(String u_name);

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
	 * 修改密码
	 * @param password
	 * @return
	 */
	boolean alterPassWord(String password);

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
}

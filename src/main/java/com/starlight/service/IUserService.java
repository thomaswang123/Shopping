package com.starlight.service;

import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 *   用户接口
 */
public interface IUserService {
	/**
	 * 根据输入的账号密码判断是否存在用户
	 * @return boolean
    */
	 int login(User user);

	/**
	 * 通过用户账号获取id
	 * @param username 用户账号
	 * @return int
    */
	 int   bynameGainId(String username);


	/**
	 * 用户注册并返回用户ID
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * 添加用户密保
	 * @param passWordProtection
	 */
	void addPWP(PassWordProtection passWordProtection);

	/**
	 * 通过账号查找用户
	 * @param account
	 * @return
	 */
	List<User> findAccount(String account);

	/**
	 * 通过ID查找用户账号
	 * @param id
	 * @return
	 */
	User findAccountById(int id);


}

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
	 * 判断是否存在该账号（前台ajax）
	 * @param u_name 账号
	 * @return   boolean
    */
	 boolean bynameJudgeUserNameExist(String u_name);

	/**
	 * 通过用户账号获取id
	 * @param u_name 用户账号
	 * @return int
    */
	 int  bynameGainId(String u_name);

	/**
	 * 获取全部的id
	 * @param number 页面展示的数据数量
	 * @return List<Integer>
	 */
	 List<Integer> findAllId(int number);

	/**
	 * 通过用户id获取用户全部的账号
	 * @param list 用户id的集合
	 * @return List<String>
	 */
	List<String> findAllNameById(List<Integer> list);

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

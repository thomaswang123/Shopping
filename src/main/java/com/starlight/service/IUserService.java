package com.starlight.service;

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
	 boolean byname_JudgeUserNameExist(String u_name);

	/**
	 * 通过用户账号获取id
	 * @param u_name 用户账号
	 * @return int
    */
	 int  byname_GainId(String u_name);

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

}

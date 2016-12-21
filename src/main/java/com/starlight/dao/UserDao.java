package com.starlight.dao;

import com.starlight.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Component
public interface UserDao {
	/**
	 * 查找所有的用户
	 * @return list
	 */
 	public 	List<User> findAll();

	/**
	 * 判断用户是否存在
	 * @param u_name 账号
	 * @param u_pwd  密码
	 * @return boolean
	 */
	public int login(User user);

	/**
	 * 通过账号来查询id
	 * @return   id
	 */
	public int findIdByAccoun_Unmber(String u_name);

	/**
	 * 用来修改用户密码
	 * @param u_id  用户的id
	 * @return
	 */
	public int alertPwdById(User user);

}

package com.starlight.dao;

import com.starlight.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Component
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


//  用户注册
void register(User user);
//	查找该用户id
int findIdByUser(String account);
//		查询账号是否存在
List<User> findAccount(String account);

//	修改密码
boolean alterPassWord(String password);

}

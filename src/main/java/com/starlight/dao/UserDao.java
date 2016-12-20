package com.starlight.dao;

import com.starlight.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Component
public interface UserDao {
	List<User> findAll();
}

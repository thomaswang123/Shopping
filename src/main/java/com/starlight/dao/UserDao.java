package com.starlight.dao;

import com.starlight.entity.UserEt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Component
public interface UserDao {
	List<UserEt> findAll();
}

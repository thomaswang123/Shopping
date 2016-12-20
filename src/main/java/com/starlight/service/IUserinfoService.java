package com.starlight.service;

import com.starlight.entity.Userinfo;

import java.util.List;

/**
 * Created by thomas.wang on 2016/12/20.
 * 用户信息接口
 */
public interface IUserinfoService {

    /**
     * 通过用户id查找用户信息（分页）
     *
     * @param List<Integer> 用户id的集合
     * @return list<Userinfo><
     */
    public List<Userinfo> findAllUserinfoById(List<Integer> list);

    /**
     * 通过姓名查询用户的信息
     *
     * @return Userinfo
     * @paramu info_nickname  用户姓名
     */
    public List<Userinfo> findUserinfoByNickName(String uinfo_nickname);


    /**
     * 通过age查询用户的信息
     *
     * @param id 用户年龄
     * @return Userinfo
     */
    public List<Userinfo> findUserinfoByAge(int age);

    /**
     * @param id
     * @return
     */
    public boolean alterPhoneById(int id);

    /**
     * 通过用户id来查询用户信息
     *
     * @param u_id
     * @return
     */
    public Userinfo findUserinfosById(int u_id);

}

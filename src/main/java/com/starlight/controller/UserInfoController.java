package com.starlight.controller;

import com.starlight.entity.UserInfo;
import com.starlight.service.IUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by james.jiang on 2016/12/28.
 * 用户详细信息控制类
 */
@Controller
public class UserInfoController {

    /**用户详细信息业务*/
    @Resource
    private IUserInfoService iUserInfoService;

    /**
     * 修改昵称
     * @param nickName 需要修改的昵称
     * @param httpSession 获取用户id
     * @return 返回提示信息
     */
    @RequestMapping(value = "/updateNickName.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateNickName(String nickName, HttpSession httpSession){
        System.out.println(nickName);
        int userId=(Integer) httpSession.getAttribute("userId");
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        userInfo.setNickname(nickName);
        iUserInfoService.updateNickName(userInfo);
        httpSession.removeAttribute("userinfo");
        UserInfo userInfo2=iUserInfoService.findUserInfoById(userId);
        httpSession.setAttribute("userinfo",userInfo2);

        return "true";
    }

    /**
     * 修改年龄
     * @param age 需要修改的年龄
     * @param httpSession  获取用户id
     * @return  提示信息
     */
    @RequestMapping(value = "/updateUserAge.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateUserAge(String age,HttpSession httpSession){
        System.out.println(age);
        int userId=(Integer) httpSession.getAttribute("userId");
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        userInfo.setAge(Integer.parseInt(age));
        iUserInfoService.updateUserAge(userInfo);
        return "true";
    }

    /**
     * 修改手机号
     * @param phone  需要修改的手机号
     * @param httpSession   获取用户id
     * @return 提示信息
     */
    @RequestMapping(value = "/updateUserPhone.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateUserPhone(String phone ,HttpSession httpSession){
        System.out.println(phone);
        int userId=(Integer) httpSession.getAttribute("userId");
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        userInfo.setPhone(phone);
        iUserInfoService.updateUserPhone(userInfo);
        return "true";
    }

    /**
     * 修改地址
     * @param place  新的地址
     * @param httpSession  获取用户id
     * @return  提示信息
     */
    @RequestMapping(value = "/updateUserAddress.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateUserAddress(String place ,HttpSession httpSession){
        System.out.println(place);
        int userId=(Integer) httpSession.getAttribute("userId");
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        userInfo.setAddress(place);
        iUserInfoService.updateUserAddress(userInfo);
        return "true";
    }
}

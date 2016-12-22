package com.starlight.controller;

import com.starlight.entity.User;
import com.starlight.serviceimp.AminServiceImp;
import com.starlight.serviceimp.UserServiceImp;
import com.starlight.serviceimp.UserinfoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Controller
public class UserController {
   //用来方便其他操作要用到u_Id的业务
    private int u_id = 0;

    //获取处理用户业务的类
    @Resource
    private UserServiceImp userServiceImp;
    //获取用户信息业务处理的类
    @Resource
    private UserinfoServiceImp userinfoServiceImp;
    //获取管理员业务处理的类
    @Resource
    private AminServiceImp aminServiceImp;

    public AminServiceImp getAminServiceImp() {
        return aminServiceImp;
    }

    public void setAminServiceImp(AminServiceImp aminServiceImp) {
        this.aminServiceImp = aminServiceImp;
    }

    public UserinfoServiceImp getUserinfoServiceImp() {
        return userinfoServiceImp;
    }

    public void setUserinfoServiceImp(UserinfoServiceImp userinfoServiceImp) {
        this.userinfoServiceImp = userinfoServiceImp;
    }

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    //登陆验证
    @RequestMapping("login.do")
    public String test(String username, String password,
                       HttpSession sessionUser, User user) {
        //为user赋值
        user.setAccount(username);
        user.setPassword(username);
        //条用UserServiceImp中的login登陆方法,判断账号密码是否正确
        if((u_id=userServiceImp.login(user)) != 0){
            sessionUser.setAttribute("userinfo",userinfoServiceImp.findUserinfosById(u_id));
            sessionUser.setAttribute("admin",aminServiceImp.finAllClssesById(u_id));
            return "Index";
        }
        return "Index";
    }

    //账号注销以及账号切换
    @RequestMapping("switchover.do")
    public String  write_Off(HttpSession sessionUser){
        //使session为null
           sessionUser.invalidate();
      //  sessionUser.setAttribute("userinfo",null);
            return "Index" ;
    }
}

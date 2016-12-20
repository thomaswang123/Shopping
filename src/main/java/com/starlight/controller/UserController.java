package com.starlight.controller;

import com.starlight.dao.UserDao;
import com.starlight.dao.UserinfoDao;
import com.starlight.entity.User;
import com.starlight.serviceimp.AminServiceImp;
import com.starlight.serviceimp.UserServiceImp;
import com.starlight.serviceimp.UserinfoServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Controller
public class UserController {
    @Resource
    private UserServiceImp userServiceImp;
    @Resource
    private UserinfoServiceImp userinfoServiceImp;
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
        user.setU_name(username);
        user.setU_pwd(username);
        //条用UserServiceImp中的login登陆方法,判断账号密码是否正确
        int u_id = 0;
        if((u_id=userServiceImp.login(user)) != 0){
            System.out.println("存在");
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
      /*      sessionUser.setAttribute("userinfo",null);*/
            return "Index" ;
    }
}

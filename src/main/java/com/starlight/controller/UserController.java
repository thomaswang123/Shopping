package com.starlight.controller;

import com.starlight.entity.PassWordProtection;
import com.starlight.entity.User;
import com.starlight.entity.UserInfo;
import com.starlight.entity.Wallet;
import com.starlight.serviceimp.AdminServiceImp;
import com.starlight.serviceimp.UserServiceImp;
import com.starlight.serviceimp.UserinfoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private AdminServiceImp adminServiceImp;

    @Resource
    User user;
    @Resource
    UserInfo userInfo;
    @Resource
    PassWordProtection passWordProtection;
    @Resource
    Wallet wallet;

    /**
     * 用户注册方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @RequestMapping("/register.do")
    public String register(String nickName, String account_number, String tel, String age, String sex, String password,
                           String payPassWord,
                           HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        System.out.println("进入注册");

        String address = httpServletRequest.getParameter("region") + httpServletRequest.getParameter("province")
                + httpServletRequest.getParameter("city") + httpServletRequest.getParameter("area");

        System.out.println(address);
        System.out.println(nickName + "--" + account_number + "--" + age + "--" + tel + "--" + sex + "--" + password + "--"
                + payPassWord);

//		插入用户表数据，并返回用户ID
        user.setAccount(account_number);
        user.setPassword(password);

        System.out.println("构建个体");
        int userId = userServiceImp.register(user);

//		插入用户详细信息表数据
        userInfo.setId(userId);
        userInfo.setNickname(nickName);
        userInfo.setAge(Integer.parseInt(age));
        userInfo.setAddress(address);
        userInfo.setPhone(tel);
        userInfo.setSex(sex);

        userinfoServiceImp.register(userInfo);

//		插入密保表数据
        String question1 = httpServletRequest.getParameter("question1");
        String question2 = httpServletRequest.getParameter("question2");
        String question3 = httpServletRequest.getParameter("question3");
        String answer1 = httpServletRequest.getParameter("answer1");
        String answer2 = httpServletRequest.getParameter("answer2");
        String answer3 = httpServletRequest.getParameter("answer3");
        String[] question = {question1, question2, question3};
        String[] answer = {answer1, answer2, answer3};

        for (int i = 0; i < question.length; i++) {
//			判断是否为空
            if (question[i] != null && answer[i] != null) {
                passWordProtection.setUserId(userId);
                passWordProtection.setQuestion(question[i]);
                passWordProtection.setAnswer(answer[i]);
//				插入数据
                userServiceImp.addPWP(passWordProtection);
            }
        }

       // 插入钱包表数据
        wallet.setId(userId);
        wallet.setPassword(Integer.parseInt(payPassWord));
        userinfoServiceImp.registerWallet(wallet);


        return "redirect:index.jsp";
    }

    /**
     * 匹配账号方法
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/checkAccout.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkAccout(String name) {
        System.out.println("进入账号验证");
//		匹配输入的账号是否符合规则并查询是否存在该账号

        if (userServiceImp.findAccount(name).isEmpty()) {
            System.out.println("进入账号正确:" + "<label style='color:green'>√</label>");
            return "true";
        } else {
            System.out.println("进入账号正确:" + "<label style='color:green'>√</label>");
            return "false";
        }
    }

    //登陆验证
    @RequestMapping("login.do")
    public String test(String username, String password,
                       HttpSession sessionUser, User user, String url) {
        //为user赋值
        user.setAccount(username);
        user.setPassword(password);
        //条用UserServiceImp中的login登陆方法,判断账号密码是否正确
        if ((u_id = userServiceImp.login(user)) != 0) {
            UserInfo userInfo = userinfoServiceImp.findUserinfosById(u_id);
            userInfo.setNickname(
                    userInfo.getNickname().length() > 2 ? userInfo.getNickname().substring(0, 1) + "…" :
                            userInfo.getNickname());
            System.out.println(userInfo.getNickname());
            sessionUser.setAttribute("userinfo", userInfo);
            //判断是否是管理员
            sessionUser.setAttribute("admin", adminServiceImp.findClssesById(u_id));
            return url;
        }
        return url;
    }


    //账号注销以及账号切换
    @RequestMapping("switchover.do")
    public String write_Off(HttpSession sessionUser, String url) {
        //使session为null
        sessionUser.invalidate();
        //  sessionUser.setAttribute("userinfo",null);
        return url;
    }

}
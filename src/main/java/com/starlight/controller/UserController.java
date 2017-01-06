package com.starlight.controller;

import com.starlight.entity.*;
import com.starlight.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by thomas.wang on 2016/12/19.
 */
@Controller
public class UserController {

    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IAdminService iAdminService;
    @Autowired
    private IWalletService iWalletService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IGoodsService iGoodsService;
    @Autowired
    private IUserService iUserService;



    /**
     * 用户注册方法
     *
     * @param httpServletRequest
     *
     */
    @RequestMapping("/register.do")
    public String register(String nickName, String account_number, String tel, String age, String sex, String password,
                           String payPassWord,
                           HttpServletRequest httpServletRequest) {

        System.out.println("进入注册");

        String address = httpServletRequest.getParameter("region") + httpServletRequest.getParameter("province")
                                 + httpServletRequest.getParameter("city") + httpServletRequest.getParameter("area");

        System.out.println(address);
        System.out.println(nickName+"--"+account_number+"--"+age+"--"+tel+"--"+sex+"--"+password+"--"
        +payPassWord);

    //		插入用户表数据，并返回用户ID
        User user=new User();
        user.setAccount(account_number);
        user.setPassword(password);

        System.out.println("构建个体");
        int userId = iUserService.register(user);

    //		插入用户详细信息表数据
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        userInfo.setNickname(nickName);
        userInfo.setAge(Integer.parseInt(age));
        userInfo.setAddress(address);
        userInfo.setPhone(tel);
        userInfo.setSex(sex);

        iUserInfoService.register(userInfo);

    //      插入管理员等级
        Admin admin=new Admin();
        admin.setId(userId);
        admin.setClasses(0);
        iAdminService.addAdmin(admin);

    //		插入密保表数据
        String question1 = httpServletRequest.getParameter("question1");
        String question2 = httpServletRequest.getParameter("question2");
        String question3 = httpServletRequest.getParameter("question3");
        String answer1 = httpServletRequest.getParameter("answer1");
        String answer2 = httpServletRequest.getParameter("answer2");
        String answer3 = httpServletRequest.getParameter("answer3");
        String[] question = {question1, question2, question3};
        String[] answer = {answer1, answer2, answer3};

        PassWordProtection passWordProtection=new PassWordProtection();
        for (int i = 0; i < question.length; i++) {
    //			判断是否为空
            if (question[i] != null && answer[i] != null) {
                passWordProtection.setUserId(userId);
                passWordProtection.setQuestion(question[i]);
                passWordProtection.setAnswer(answer[i]);
    //				插入数据
                iUserService.addPWP(passWordProtection);
            }
        }

    //		插入钱包表数据
        Wallet wallet=new Wallet();
        wallet.setId(userId);
        wallet.setPassword(Integer.parseInt(payPassWord));
        iUserInfoService.registerWallet(wallet);
        System.out.println("注册成功！");
        return "redirect:index.jsp";
    }

    /**
     * 匹配账号方法
     *
     * @param name
     *
     * @return
     */
    @RequestMapping(value = "/checkAccout.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkAccout(String name) {
        System.out.println("进入账号验证");
    //		匹配输入的账号是否符合规则并查询是否存在该账号

        if (iUserService.findAccount(name).isEmpty()) {
            return "true";
        }
            return "false";

    }

        //登陆验证
        @RequestMapping("login.do")
        public String test (String username, String password, HttpSession sessionUser, User user,String url){
        System.out.println("登陆方法");
            int id;
            //为user赋值
            user.setAccount(username);
            user.setPassword(password);
            //条用UserServiceImp中的login登陆方法,判断账号密码是否正确
            if ((id = iUserService.login(user)) != 0) {
                System.out.println();
                UserInfo userInfo = iUserInfoService.findUserInfoById(id);
                userInfo.setNickname(
                        userInfo.getNickname().length() > 2 ? userInfo.getNickname().substring(0, 1) + "…" :
                                userInfo.getNickname());
                sessionUser.setAttribute("userinfo", userInfo);
                //判断是否是管理员
                sessionUser.setAttribute("admin", iAdminService.findClassesById(id));
                sessionUser.setAttribute("userId",id);
                sessionUser.setAttribute("userClasses",iAdminService.findClassesById(id));
                return url;
            }
            return url;
        }

        //账号注销以及账号切换
        @RequestMapping("switchover.do")
        public String write_Off (HttpSession sessionUser){
            //使session为null
            sessionUser.invalidate();

            return "redirect:index.jsp";
        }

    //    个人信息展示
        @RequestMapping("/personal.do")
        public String personal(HttpSession httpSession){
            int userId=(Integer)httpSession.getAttribute("userId");
    //        查找账号
            User user=iUserService.findAccountById(userId);
            System.out.println(user.getId()+"--"+user.getPassword()+"--"+user.getAccount());

    //      创建session
            httpSession.setAttribute("user",user);

    //      查找用户详细信息
            UserInfo userInfo=iUserInfoService.findUserInfoById(userId);
            System.out.println(userInfo.getAddress()+"--"+userInfo.getNickname()+"--"
                    +userInfo.getPhone()+"--"+userInfo.getSex()+"--"+userInfo.getAge());

    //       创建session
            httpSession.setAttribute("userInfo",userInfo);

    //        查找钱包信息
            Wallet wallet=iWalletService.findById(userId);
            System.out.println(wallet.getPassword()+"--"+wallet.getMoney());

    //        创建session
            httpSession.setAttribute("wallet",wallet);

    //        查找账单
            List<Order> orderList=iOrderService.findByUserId(userId);

            for (Order o:orderList) {
                Goods goods=iGoodsService.findById(o.getGoodsId());
                o.setGoodsName(goods.getName());
                o.setPicture(goods.getPicture());
                o.setPrice(goods.getPrice());
            }


//        创建session
        httpSession.setAttribute("orderList",orderList);

        return "redirect:personal.jsp";
    }
}
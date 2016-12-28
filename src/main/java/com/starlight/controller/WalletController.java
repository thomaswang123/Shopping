package com.starlight.controller;

import com.starlight.entity.Wallet;
import com.starlight.serviceimp.WalletServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by james.jiang on 2016/12/28.
 * 钱包操作类
 */
@Controller
public class WalletController {
    @Resource
    WalletServiceImp walletServiceImp;


    @RequestMapping(value = "/chargeMoney.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String chargeMoney(String password,String money,HttpSession httpSession){
        System.out.print("充入：--"+password+"--"+money);
        int pwd=Integer.parseInt(password);
        float money1=Float.parseFloat(money);
//        校验密码是否正确
        Wallet wallet=(Wallet) httpSession.getAttribute("wallet");
//      如果密码正确就进行下一步
        if(wallet.getPassword()==pwd){
            System.out.println("密码："+wallet.getPassword());
            wallet.getMoney();
            wallet.setMoney(wallet.getMoney()+money1);
//            修改数据库
            walletServiceImp.updateMoney(wallet);
            httpSession.setAttribute("wallet",wallet);
            return "true";
        }else{
            return "false";
        }

    }


}

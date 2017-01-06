package com.starlight.controller;

import com.starlight.entity.Wallet;
import com.starlight.service.IWalletService;
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

    /**用户钱包*/
    @Resource
    private IWalletService iWalletService;

    /**
     * 钱包充值
     * @param password 钱包支付密码
     * @param money  充入金额
     * @param httpSession  session
     * @return 提示信息
     */
    @RequestMapping(value = "/chargeMoney.do", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String chargeMoney(String password,String money,HttpSession httpSession){
        System.out.print("充入：--"+password+"--"+money);
        int pwd=Integer.parseInt(password);
        float money1=Float.parseFloat(money);
        //校验密码是否正确
        int userId=(Integer)httpSession.getAttribute("userId");
        Wallet wallet= iWalletService.findById(userId);

        // 如果密码正确就进行下一步
        if(wallet.getPassword()==pwd){
            System.out.println("密码："+wallet.getPassword());
            wallet.setMoney(wallet.getMoney()+money1);

            //修改数据库
            iWalletService.updateMoney(wallet);
            System.out.println("合格");
            //查询数据库
            httpSession.removeAttribute("wallet");
            httpSession.setAttribute("wallet",iWalletService.findById(userId));
            return "true";
        }

        return "false";

    }

}

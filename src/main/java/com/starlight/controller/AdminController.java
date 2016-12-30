package com.starlight.controller;

import com.starlight.dao.IAdminDao;
import com.starlight.dao.IGoodsDao;
import com.starlight.entity.Paging;
import com.starlight.serviceimp.AdminServiceImp;
import com.starlight.serviceimp.GoodsServiceImp;
import com.starlight.serviceimp.UserInfoServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by thomas.wang on 2016/12/23.
 * 管理员
 */
@Controller
public class AdminController {

   @Resource
   UserInfoServiceImp userInfoServiceImp;

   @Resource
   AdminServiceImp adminServiceImp;

   @Resource
   GoodsServiceImp goodsServiceImp;

   @Resource
    IAdminDao iAdminDao;

   @Resource
    IGoodsDao iGoodsDao;


    //进入用户管理员界面
    @RequestMapping("userControl.do")
    public String adminInit(int number, int pagination, Paging paging, HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userdata", userInfoServiceImp.byPagingfindAll(paging));
        sessionPaging.setAttribute("goodsdata",null);
        sessionPaging.setAttribute("userRight",null);
        //处理页数
        int numbersum = userInfoServiceImp.countUserIdNumber();

        if(number>numbersum){
            numbersum=0;
        }else {
            if ((numbersum%number!=0)){
                numbersum=numbersum/number+1;
            }else {
                numbersum=numbersum/number;
            }
            System.out.println(numbersum);
        }

        //数据发送到当前页面展示
        rst.setAttribute("number", numbersum);
        rst.setAttribute("datanumber",number);
        rst.setAttribute("numbersum", userInfoServiceImp.countUserIdNumber());
        rst.setAttribute("goodstemp",0);
        return "admin";
    }

    //进行相关页码的数据的展示
    @RequestMapping("pagination.do")
    @ResponseBody
    public String pagination(String pagination, String number,int goodsnumber, HttpSession sessionPaging) {
        System.out.println("页码" + pagination);
        System.out.println(number);
     /*    sessionPaging.invalidate();*/
        //利用session机制，进行页面的展示数据
        if(goodsnumber!=1&&goodsnumber!=2){
            sessionPaging.setAttribute("userdata", userInfoServiceImp.pagination(pagination, number));
        }else if(goodsnumber == 2){
            //页面的数据数量
            int nbr = Integer.parseInt(number.substring(number.indexOf(":") + 1, number.length()));
            //页码
            int pat = Integer.parseInt(pagination);
            Paging paging = new Paging();
            //从第几个数据开始
            paging.setRise(pat * nbr - nbr);
            //那个数据结束
            paging.setStop(pat * nbr);
            sessionPaging.setAttribute("userRight", adminServiceImp.findAdminByPaging(paging));
        }else{
            sessionPaging.setAttribute("goodsdata", adminServiceImp.pagination(pagination,number));
        }
        return "yes";
    }

    //删除相对应的用户数据
    @RequestMapping("deluser.do")
    @ResponseBody
    public String deluser(String uid) {
        System.out.println(uid);
        if (adminServiceImp.delAllUserData(Integer.parseInt(uid))!=0){
            return "删除成功！";
        }
        return "可能还有数据存在，删除不了";
    }


    //进商品管理界面
    @RequestMapping("goods.do")
    public String shoppingInit(int number, int pagination, Paging paging,
                               HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("goodsdata", adminServiceImp.findAllByPaging(paging));
        sessionPaging.setAttribute("userdata",null);
        sessionPaging.setAttribute("userRight",null);
        //处理页数
        int numbersum = adminServiceImp.conutGoodsDataNumber();

        if (number>numbersum){
            numbersum=0;
        }else {
            if ((numbersum%number!=0)){
                numbersum=numbersum/number+1;
            }else {
                numbersum=numbersum/number;
            }
            System.out.println(numbersum);
        }

        //数据发送到当前页面展示
        rst.setAttribute("number", numbersum);
        rst.setAttribute("datanumber",number);
        rst.setAttribute("numbersum", adminServiceImp.conutGoodsDataNumber());
        rst.setAttribute("maxid",iGoodsDao.findMaxId());
        return "admin";
    }

    //进入用户权限管理界面
    @RequestMapping("userRight.do")
    public String userRightInit(int number, int pagination, Paging paging,
                                HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userRight", adminServiceImp.findAdminByPaging(paging));
        sessionPaging.setAttribute("userdata",null);
        sessionPaging.setAttribute("goodsdata",null);
        //处理页数
        int numbersum =iAdminDao.countAdminnumber();
        if (number > numbersum) {
            numbersum = 0;
        } else {
            if (numbersum % number != 0) {
                numbersum = numbersum / number + 1;
            } else {
                numbersum = numbersum / number;
            }
            System.out.println(numbersum);
        }
        //数据发送到当前页面展示
        rst.setAttribute("number", numbersum);
        rst.setAttribute("datanumber",number);
        rst.setAttribute("numbersum", iAdminDao.countAdminnumber());
        return "admin";
    }

//上传图片
    @RequestMapping("addgoodsdata.do")
    public String addGoods(MultipartFile file, String goodsname, String goodsprivce, String goodsid, String goodsnumber, String gdsdescribe){
           System.out.println(file);
           System.out.println(goodsid);
             return "yes";
    }
}

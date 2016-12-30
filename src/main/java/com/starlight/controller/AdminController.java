package com.starlight.controller;

import com.starlight.dao.IAdminDao;
import com.starlight.dao.IGoodsDao;
import com.starlight.dao.IUserDao;
import com.starlight.entity.*;
import com.starlight.serviceimp.AdminServiceImp;
import com.starlight.serviceimp.GoodsServiceImp;
import com.starlight.serviceimp.UserInfoServiceImp;
import org.springframework.expression.spel.InternalParseException;
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
    IUserDao iUserDao;

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
        rst.setAttribute("datanumber", number);
        rst.setAttribute("type","账号");
        //商品条件的标示
        rst.setAttribute("temp",0);
        //管理员的分页
        rst.setAttribute("userRightTemp",0);
        //用户管理分页
        rst.setAttribute("userTemp",0);
        rst.setAttribute("numbersum", userInfoServiceImp.countUserIdNumber());
        return "admin";
    }

    //进行相关页码的数据的展示
    @RequestMapping("pagination.do")
    @ResponseBody
    public String pagination(String Account ,int userTemp,
                             String pagination,String goodsCondition,
                             String number, int goodsnumber,String price,
                             HttpSession sessionPaging,int userRightTemp,String userRightClasses) {
        System.out.println("页码" + pagination);
        System.out.println(number);
        int temp = Integer.parseInt(goodsCondition);
        //页面的数据数量
        int nbr = Integer.parseInt(number.substring(number.indexOf(":") + 1, number.length()));
        //页码
        int pat = Integer.parseInt(pagination);
        //利用session机制，进行页面的展示数据
        if(temp ==1){
            /*这里是根据商品的单价进行查询*/
            System.out.println("yes");
            Paging paging = new Paging();
            //从第几个数据开始
            paging.setRise(pat * nbr - nbr);
            //那个数据结束
            paging.setStop(pat * nbr);
            paging.setPrice(Float.parseFloat(price));
            sessionPaging.setAttribute("goodsdata", adminServiceImp.findByGoodsPrice(paging));
            sessionPaging.setAttribute("number", nbr);
        }else if(userRightTemp==1) {
           // 这里是根据商品的单价进行查询
            Paging paging = new Paging();
            //从第几个数据开始
            paging.setRise(pat * nbr - nbr);
            //那个数据结束
            paging.setStop(pat * nbr);
            sessionPaging.setAttribute("userRight",
                    adminServiceImp.findByAdminClasses(paging,Integer.parseInt(userRightClasses)));
            sessionPaging.setAttribute("number", nbr);
        }else if(userTemp==1){
        // 这里是根据用户的账号进行查询
            Paging paging = new Paging();
            //从第几个数据开始
            paging.setRise(pat * nbr - nbr);
            //那个数据结束
            paging.setStop(pat * nbr);
            paging.setName(Account);
            sessionPaging.setAttribute("userdata",
                    adminServiceImp.findAllByLikeName(paging));
            sessionPaging.setAttribute("number", nbr);
        }else{
            if (goodsnumber != 1 && goodsnumber != 2) {
                sessionPaging.setAttribute("userdata", userInfoServiceImp.pagination(pagination, number));
            } else if (goodsnumber == 2) {
                Paging paging = new Paging();
                //从第几个数据开始
                paging.setRise(pat * nbr - nbr);
                //那个数据结束
                paging.setStop(pat * nbr);
                sessionPaging.setAttribute("userRight", adminServiceImp.findAdminByPaging(paging));
                sessionPaging.setAttribute("number", nbr);
            } else {
                sessionPaging.setAttribute("goodsdata", adminServiceImp.pagination(pagination, number));
            }
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
        //用于删除
        sessionPaging.setAttribute("number", number);
        rst.setAttribute("datanumber", number);
        rst.setAttribute("type", "商品单价");
        //商品条件的标示
        rst.setAttribute("temp",0);
        //管理员的分页
        rst.setAttribute("userRightTemp",0);
        //用户管理分页
        rst.setAttribute("userTemp",0);
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
        rst.setAttribute("datanumber", number);
        rst.setAttribute("type", "级别");
        //商品条件的标示
        rst.setAttribute("temp",0);
        //管理员分页
        rst.setAttribute("userRightTemp",0);
        //用户管理分页
        rst.setAttribute("userTemp",0);
        rst.setAttribute("numbersum", iAdminDao.countAdminnumber());
        return "admin";
    }

    //修改商品的信息
    @RequestMapping("alertGoods.do")
    @ResponseBody
    public String alertGoodsData(Goods goods, Repertory repertory, int goodsId, float price, String goodsName, String describe, int goodsNumber) {
        if (price == 0) {
            return "no";
        } else if (goodsName == null || goodsName == "") {
            return "no";
        } else {
            //商品信息
            goods.setId(goodsId);
            goods.setDescribe(describe);
            goods.setName(goodsName);
            goods.setPrice(price);
            //库存
            repertory.setId(goodsId);
            repertory.setNumber(goodsNumber);
            goods.setRepertory(repertory);
            if (adminServiceImp.alterGoodsData(goods, repertory) != 0) {
                return "修改成功";
            } else {
                return "no";
            }
        }
    }


    //删除商品信息
    @RequestMapping("delGoods.do")
    @ResponseBody
    public String deleteGoods(int goodsId, int number) {
        //判断是否删除成功
        if (adminServiceImp.delGoodsData(goodsId) != 0) {
            return "删除成功";
        }
        return null;
    }

    //根据商品价格查找商品信息
    @RequestMapping("findByGoodsPrice.do")
    public String findByGoodsPrice(float price, String numbers, int pagination, Paging paging,
                                   HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        int number = Integer.parseInt(numbers.substring(numbers.indexOf(":") + 1, numbers.length()));
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        paging.setPrice(price);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("goodsdata", adminServiceImp.findByGoodsPrice(paging));
        sessionPaging.setAttribute("userdata", null);
        sessionPaging.setAttribute("userRight", null);
        //处理页数
        int numbersum = iGoodsDao.findSumNumberByPrice(paging);
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
        rst.setAttribute("datanumber", number);
        rst.setAttribute("type", "商品单价");
        //商品的条件标示
        rst.setAttribute("price",price);
        rst.setAttribute("temp",1);
        //管理员的分页
        rst.setAttribute("userRightTemp",0);
        //用户管理分页
        rst.setAttribute("userTemp",0);
        rst.setAttribute("maxid", iGoodsDao.findMaxId());
        rst.setAttribute("numbersum", iGoodsDao.findSumNumberByPrice(paging));
        return "admin";
    }

    //设置管理员的等级,也是间接添加管理员删除管理员
    @RequestMapping("alterAdmin.do")
    @ResponseBody
    public String alterClasses(int alterClasses, int classes, int id, HttpSession session, Admin admin){
        System.out.println(classes+","+id);
        Integer uid=(Integer)session.getAttribute("userClasses");
        admin.setId(id);
        admin.setClasses(alterClasses);
        return adminServiceImp.alterAdminClasses(admin,uid,classes);
    }

    //根据管理员的级别查找管理相关信息
    @RequestMapping("findByAdminClasses.do")
    public String findByGoodsPrice(int classes, String numbers, int pagination, Paging paging,
                                   HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        int number = Integer.parseInt(numbers.substring(numbers.indexOf(":") + 1, numbers.length()));
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        paging.setClasses(classes);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userRight", adminServiceImp.findByAdminClasses(paging,classes));
        sessionPaging.setAttribute("userdata", null);
        sessionPaging.setAttribute("goodsdata", null);
        //处理页数
        int numbersum = iAdminDao.findSumNumberByClasses(paging);
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
        rst.setAttribute("datanumber", number);
        rst.setAttribute("type", "级别");
        //商品分页条件标示
        rst.setAttribute("temp",0);
        //权限分页条件标示
        rst.setAttribute("classes",classes);
        rst.setAttribute("userRightTemp",1);
        //用户管理分页
        rst.setAttribute("userTemp",0);
        rst.setAttribute("numbersum",iAdminDao.findSumNumberByClasses(paging));
         return "admin";
    }

    //根据用户的账号来查找用户相关信息
    @RequestMapping("findByLikeName.do")
    public String findByLikeName(String Account, String numbers, int pagination, Paging paging,
                                   HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        int number = Integer.parseInt(numbers.substring(numbers.indexOf(":") + 1, numbers.length()));
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        paging.setName(Account+"%");
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userdata", adminServiceImp.findAllByLikeName(paging));
        sessionPaging.setAttribute("userRight", null);
        sessionPaging.setAttribute("goodsdata", null);
        //处理页数
        int numbersum =iUserDao.findByLikeNameNumber(paging);
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
        rst.setAttribute("datanumber", number);
        rst.setAttribute("type", "账号");
        //商品分页条件标示
        rst.setAttribute("temp",0);
        //管理员分页条件标示
        rst.setAttribute("userRightTemp",0);
        //用户管理分页
        rst.setAttribute("Account",Account);
        rst.setAttribute("userTemp",1);
        rst.setAttribute("numbersum",iUserDao.findByLikeNameNumber(paging));
        return "admin";
    }
}

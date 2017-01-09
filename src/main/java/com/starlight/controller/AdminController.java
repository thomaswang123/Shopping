package com.starlight.controller;

import com.starlight.entity.Admin;
import com.starlight.entity.Goods;
import com.starlight.entity.Paging;
import com.starlight.entity.Repertory;
import com.starlight.service.IAdminService;
import com.starlight.service.IGoodsService;
import com.starlight.service.IUserInfoService;
import com.starlight.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by thomas.wang on 2016/12/23.
 * 管理员控制类
 */
@Controller
public class AdminController {

    /**用户详细信息业务*/
    @Resource
    private IUserInfoService iUserInfoService;

    /**管理员业务*/
    @Resource
    private IAdminService iAdminService;

    /**用户账号业务*/
    @Resource
    private IUserService iUserService;

    /**商品业务*/
    @Resource
    private IGoodsService iGoodsService;


    /**
     * 进入用户管理员界面
     * @param number    用户账号
     * @param pagination    页码
     * @param sessionPaging session
     * @param rst   响应数据
     * @return  跳转至admin.jsp页面
     */
    @RequestMapping("userControl.do")
    public String adminInit(int number, int pagination,HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        Paging paging=new Paging();
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
//        sessionPaging.setAttribute("userdata", iUserInfoService.byPagingfindAll(paging));
        sessionPaging.setAttribute("goodsdata",null);
        sessionPaging.setAttribute("userRight",null);
        //处理页数
        int numbersum = iUserInfoService.countUserIdNumber();

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

        rst.setAttribute("numbersum", iUserInfoService.countUserIdNumber());
        return "redirect:admin.jsp";
    }

    /**
     * 进行相关页码的数据的展示
     * @param Account   账号
     * @param userTemp  用户分页
     * @param pagination    页码
     * @param goodsCondition    商品
     * @param number    分页数
     * @param goodsnumber   商品数量
     * @param price 商品价格
     * @param sessionPaging 用来分页的session
     * @param userRightTemp 用户
     * @param userRightClasses  用户等级
     * @return  提示信息
     */
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
            if(pat==1) {
                //从第几个数据开始
                paging.setRise(pat * nbr - nbr);
                //那个数据结束
                paging.setStop(pat * nbr);
            }else{
                //从第几个数据开始
                paging.setRise(pat * nbr-nbr);
                //那个数据结束
                paging.setStop(nbr);
                System.out.println(pat * nbr - nbr+","+nbr);
            }
            paging.setPrice(Float.parseFloat(price));
            sessionPaging.setAttribute("goodsdata", iAdminService.findByGoodsPrice(paging));
            sessionPaging.setAttribute("number", nbr);
        }else if(userRightTemp==1) {
            // 这里是根据商品的单价进行查询
            Paging paging = new Paging();
            if(pat==1) {
                //从第几个数据开始
                paging.setRise(pat * nbr - nbr);
                //那个数据结束
                paging.setStop(pat * nbr);
            }else{
                //从第几个数据开始
                paging.setRise(pat * nbr-nbr);
                //那个数据结束
                paging.setStop(nbr);
                System.out.println(pat * nbr - nbr+","+nbr);
            }
            sessionPaging.setAttribute("userRight",
                    iAdminService.findByAdminClasses(paging,Integer.parseInt(userRightClasses)));
            sessionPaging.setAttribute("number", nbr);
        }else if(userTemp==1){
            // 这里是根据用户的账号进行查询
            Paging paging = new Paging();
            if(pat==1) {
                //从第几个数据开始
                paging.setRise(pat * nbr - nbr);
                //那个数据结束
                paging.setStop(pat * nbr);
            }else{
                //从第几个数据开始
                paging.setRise(pat * nbr-nbr);
                //那个数据结束
                paging.setStop(nbr);
                System.out.println(pat * nbr - nbr+","+nbr);
            }
            paging.setName(Account);
            sessionPaging.setAttribute("userdata",
                    iAdminService.findAllByLikeName(paging));
            sessionPaging.setAttribute("number", nbr);
        }else{
            if (goodsnumber != 1 && goodsnumber != 2) {
                sessionPaging.setAttribute("userdata", iUserInfoService.pagination(pagination, number));
            } else if (goodsnumber == 2) {
                Paging paging = new Paging();
                if(pat==1) {
                    //从第几个数据开始
                    paging.setRise(pat * nbr - nbr);
                    //那个数据结束
                    paging.setStop(pat * nbr);
                }else{
                    //从第几个数据开始
                    paging.setRise(pat * nbr-nbr);
                    //那个数据结束
                    paging.setStop(nbr);
                    System.out.println(pat * nbr - nbr+","+nbr);
                }
                sessionPaging.setAttribute("userRight", iAdminService.findAdminByPaging(paging));
                sessionPaging.setAttribute("number", nbr);
            } else {
                sessionPaging.setAttribute("goodsdata", iAdminService.pagination(pagination, number));
            }
        }
        return "yes";
    }

    /**
     * 删除相对应的用户数据
     * @param uid 用户id
     * @return 提示
     */
    @RequestMapping("deluser.do")
    @ResponseBody
    public String deluser(String uid) {
        System.out.println(uid);
        if (iAdminService.delAllUserData(Integer.parseInt(uid))!=0){
            return "删除成功！";
        }
        return "可能还有数据存在，删除不了";
    }


    /**
     * 进商品管理界面
     * @param number    数量
     * @param pagination    页码
     * @param paging    分页
     * @param sessionPaging session
     * @param rst   响应数据
     * @return  跳转至admin.jsp页面
     */
    @RequestMapping("goods.do")
    public String shoppingInit(int number, int pagination, Paging paging,
                               HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("goodsdata", iAdminService.findAllByPaging(paging));
        sessionPaging.setAttribute("userdata",null);
        sessionPaging.setAttribute("userRight",null);
        //处理页数
        int numbersum = iAdminService.conutGoodsDataNumber();

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
        rst.setAttribute("numbersum", iAdminService.conutGoodsDataNumber());
        rst.setAttribute("maxid",iGoodsService.findMaxId());
        return "redirect:admin.jsp";
    }

    /**
     * 进入用户权限管理界面
     * @param number    数量
     * @param pagination    分页
     * @param paging    分页
     * @param sessionPaging 用来分页的session
     * @param rst   响应数据
     * @return    页面跳转
     */
    @RequestMapping("userRight.do")
    public String userRightInit(int number, int pagination, Paging paging,
                                HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userRight", iAdminService.findAdminByPaging(paging));
        sessionPaging.setAttribute("userdata",null);
        sessionPaging.setAttribute("goodsdata",null);
        //处理页数
        int numbersum =iAdminService.countAdminnumber();
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
        rst.setAttribute("numbersum", iAdminService.countAdminnumber());
        return "redirect:admin.jsp";
    }

    /**
     * 修改商品的信息
     * @param goodsId   商品id
     * @param price 价格
     * @param goodsName 商品数量
     * @param describe  商品描述
     * @param goodsNumber   商品数量
     * @return  提示信息
     */
    @RequestMapping("alertGoods.do")
    @ResponseBody
    public String alertGoodsData(int goodsId, float price, String goodsName, String describe, int goodsNumber) {
        if (price == 0) {
            return "no";
        } else if (goodsName == null || goodsName.equals("")) {
            return "no";
        } else {
            //商品信息
            Goods goods=new Goods();
            goods.setId(goodsId);
            goods.setDescribe(describe);
            goods.setName(goodsName);
            goods.setPrice(price);
            //库存
            Repertory repertory=new Repertory();
            repertory.setId(goodsId);
            repertory.setNumber(goodsNumber);
            goods.setRepertory(repertory);
            if (iAdminService.alterGoodsData(goods, repertory) != 0) {
                return "修改成功";
            } else {
                return "no";
            }
        }
    }


    /**
     * 删除商品信息
     * @param goodsId 商品id
     * @return  提示信息
     */
    @RequestMapping("delGoods.do")
    @ResponseBody
    public String deleteGoods(int goodsId) {
        //判断是否删除成功
        if (iAdminService.delGoodsData(goodsId) != 0) {
            return "删除成功";
        }
        return null;
    }

    /**
     * 根据商品价格查找商品信息
     * @param price     商品价格
     * @param numbers   商品数量
     * @param pagination    页码
     * @param sessionPaging  session
     * @param rst   响应信息
     * @return  跳转至admin.jsp页面
     */
    @RequestMapping("findByGoodsPrice.do")
    public String findByGoodsPrice(float price, String numbers, int pagination,HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        int number = Integer.parseInt(numbers.substring(numbers.indexOf(":") + 1, numbers.length()));
        Paging paging=new Paging();
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        paging.setPrice(price);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("goodsdata", iAdminService.findByGoodsPrice(paging));
        sessionPaging.setAttribute("userdata", null);
        sessionPaging.setAttribute("userRight", null);
        //处理页数
        int numbersum = iGoodsService.findSumNumberByPrice(paging);
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
        rst.setAttribute("maxid", iGoodsService.findMaxId());
        rst.setAttribute("numbersum", iGoodsService.findSumNumberByPrice(paging));
        return "redirect:admin.jsp";
    }

    /**
     * 修改管理员权限
     * @param alterClasses  修改的级别
     * @param classes   用户拥有的级别
     * @param id    用户id
     * @param session   session
     * @return  提示信息
     */
    @RequestMapping("alterAdmin.do")
    @ResponseBody
    public String alterClasses(int alterClasses, int classes, int id, HttpSession session){
        System.out.println(classes+","+id);
        Integer uid=(Integer)session.getAttribute("userClasses");
        Admin admin=new Admin();
        admin.setId(id);
        admin.setClasses(alterClasses);
        return iAdminService.alterAdminClasses(admin,uid,classes);
    }

    /**
     * 根据管理员的级别查找管理相关信息
     * @param classes   用户级别
     * @param numbers   数量
     * @param pagination    页码
     * @param sessionPaging 请求信息
     * @param rst   响应信息
     * @return   跳转至admin.jsp页面
     */
    @RequestMapping("findByAdminClasses.do")
    public String findByGoodsPrice(int classes, String numbers, int pagination,HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        int number = Integer.parseInt(numbers.substring(numbers.indexOf(":") + 1, numbers.length()));
        Paging paging=new Paging();
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        paging.setClasses(classes);
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userRight", iAdminService.findByAdminClasses(paging,classes));
        sessionPaging.setAttribute("userdata", null);
        sessionPaging.setAttribute("goodsdata", null);
        //处理页数
        int numbersum = iAdminService.findSumNumberByClasses(paging);
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
        rst.setAttribute("numbersum",iAdminService.findSumNumberByClasses(paging));
        return "redirect:admin.jsp";
    }

    /**
     * 根据用户的账号来查找用户相关信息
     * @param Account 账号
     * @param numbers  数量
     * @param pagination  页码
     * @param sessionPaging 请求信息
     * @param rst  响应数据
     * @return 跳转至admin.jsp页面
     */
    @RequestMapping("findByLikeName.do")
    public String findByLikeName(String Account, String numbers, int pagination,HttpSession sessionPaging, HttpServletRequest rst) {
        //设置分页的数据pagination为第几页number为一页有多数据
        int number = Integer.parseInt(numbers.substring(numbers.indexOf(":") + 1, numbers.length()));
        Paging paging=new Paging();
        paging.setRise((pagination * number) - number);
        paging.setStop(number * pagination);
        paging.setName(Account+"%");
        //利用session机制，进行页面的展示数据
        sessionPaging.setAttribute("userdata", iAdminService.findAllByLikeName(paging));
        sessionPaging.setAttribute("userRight", null);
        sessionPaging.setAttribute("goodsdata", null);
        //处理页数
        int numbersum =iUserService.findByLikeNameNumber(paging);
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
        rst.setAttribute("numbersum",iUserService.findByLikeNameNumber(paging));
        return "redirect:admin.jsp";
    }
}

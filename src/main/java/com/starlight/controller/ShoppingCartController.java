package com.starlight.controller;

import com.starlight.entity.Goods;
import com.starlight.entity.ShoppingCart;
import com.starlight.serviceimp.GoodsServiceImp;
import com.starlight.serviceimp.ShoppingCartServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 * 购物车Controller层
 */
@Controller
public class ShoppingCartController {
	@Resource
	ShoppingCartServiceImp shoppingCartSI;
	@Resource
	GoodsServiceImp goodsServiceImp;
	@Resource
	List<ShoppingCart> shoppingCartsList;
	@Resource
	ShoppingCart shoppingCart;

	@RequestMapping(value = "/addToCart.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addToCart(int id,String quantity,HttpSession httpSession){
		System.out.println("id:"+id);
		System.out.println("q:"+quantity);

		int uid=(Integer)httpSession.getAttribute("userId");
		System.out.println("用户："+uid);
		Goods g=goodsServiceImp.findById(id);

//		计算价格
		Float total=g.getPrice()*Integer.parseInt(quantity);
		System.out.println("总价："+total);

//      生成本地时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(date);
		System.out.print(str);


//		将数据添加到对象中
		shoppingCart.setUserId(uid);
		shoppingCart.setGoodsId(id);
		shoppingCart.setNumber(Integer.parseInt(quantity));
		shoppingCart.setTotalMoney(total);
		shoppingCart.setDate(str);
		System.out.println("对象构建完成");
//		添加到数据库
		shoppingCartSI.addToCart(shoppingCart);
		System.out.println("添加到数据库");
//		获取购物车
		List<ShoppingCart> sc=shoppingCartSI.findById(uid);
		System.out.println("添加到数据库");
//		创建临时仓库
		List<Goods> goods2=(List<Goods>) httpSession.getAttribute("showAllGoods");
		for (Goods g3:
		     goods2) {
			System.out.println(g3.getId()+"--"+g3.getName()+"--"+g3.getPicture()+"--"+g3.getPrice()+"--"+g3.getDescribe());
		}
		for (ShoppingCart sc2:
		     sc) {
			System.out.println("sc:"+sc2.getGoodsId()+"--"+sc2.getGoodsName()+"--"+sc2.getGoodsPrice());
		}
		for (Goods g2:goods2) {
			for (ShoppingCart sc2:sc) {
				if(sc2.getGoodsId()==g2.getId()){
					System.out.println("id:"+g2.getId()+"--"+g2.getName());
					sc2.setGoodsName(g2.getName());
					sc2.setGoodsPrice(g2.getPrice());
					sc2.setgPicture(g2.getPicture());
				}
			}
		}
		if(sc!=null){
			for (ShoppingCart scs:
			     sc) {
				System.out.print("ShoppingCart："+scs.getGoodsId()+"__"+scs.getId()+"__"+scs.getDate());
			}


			System.out.println("有数据");
			httpSession.setAttribute("cartList",sc);
			System.out.println("跳转");
		}

		return "true";
	}
}

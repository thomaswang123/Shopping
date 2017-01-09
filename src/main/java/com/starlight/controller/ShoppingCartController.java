package com.starlight.controller;

import com.starlight.entity.Goods;
import com.starlight.entity.Order;
import com.starlight.entity.ShoppingCart;
import com.starlight.entity.Wallet;
import com.starlight.service.IGoodsService;
import com.starlight.service.IOrderService;
import com.starlight.service.IShoppingCartService;
import com.starlight.service.IWalletService;
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

	/**购物车业务*/
	@Resource
	private IShoppingCartService iShoppingCartService;

	/**商品业务*/
	@Resource
	private IGoodsService iGoodsService;

	/**钱包业务*/
	@Resource
	private IWalletService iWalletService;

	/**订单业务*/
	@Resource
	private IOrderService iOrderService;

	/**
	 * 添加商品至购物车
	 * @param id	商品id
	 * @param quantity	商品数量
	 * @param httpSession	session
	 * @return	返回提示信息
	 */
	@RequestMapping(value = "/addToCart.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addToCart(int id,String quantity,HttpSession httpSession){
		System.out.println("id:"+id);
		System.out.println("q:"+quantity);

		if(httpSession.getAttribute("userId")!=null){
			int uid=(Integer)httpSession.getAttribute("userId");
			System.out.println("用户："+uid);
			Goods g=iGoodsService.findById(id);

//		计算价格
			Float total=g.getPrice()*Integer.parseInt(quantity);
			System.out.println("总价："+total);

//      生成本地时间
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str=sdf.format(date);
			System.out.print(str);


//		将数据添加到对象中
			ShoppingCart shoppingCart=new ShoppingCart();
			shoppingCart.setUserId(uid);
			shoppingCart.setGoodsId(id);
			shoppingCart.setNumber(Integer.parseInt(quantity));
			shoppingCart.setTotalMoney(total);
			shoppingCart.setDate(str);
			System.out.println("对象构建完成");
//		添加到数据库
			iShoppingCartService.addToCart(shoppingCart);
			System.out.println("添加到数据库");
//		获取购物车
			List<ShoppingCart> sc=iShoppingCartService.findById(uid);
			System.out.println("添加到数据库");
//		创建临时仓库

		List<Goods> goods2=(List<Goods>) httpSession.getAttribute("showAllGoods");

			for (Goods g2:goods2) {
				for (ShoppingCart sc2:sc) {
					if(sc2.getGoodsId()==g2.getId()){
						sc2.setGoodsName(g2.getName());
						sc2.setGoodsPrice(g2.getPrice());
						sc2.setgPicture(g2.getPicture());

					}
				}
			}
			if(sc!=null){
				for (ShoppingCart sn :
						sc) {
					System.out.println(sn.getGoodsId()+"_____"+sn.getNumber());
				}

				httpSession.setAttribute("cartList",sc);
				System.out.println("跳转");
				return "true";
			}
		}else {
			return "noBody";
		}

		return "false";
	}

	/**
	 * 从购物车中删除信息
	 * @param id	商品id
	 * @param httpSession	session
	 * @return	ajax的提示信息
	 */
	@RequestMapping(value = "/removeOfCart.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String removeOfCart(String id,HttpSession httpSession){
		System.out.println("Sid:"+id);
		int scid=Integer.parseInt(id);
//		删除一条数据
		iShoppingCartService.removeOfCart(scid);
		List<ShoppingCart> sc2=(List<ShoppingCart>) httpSession.getAttribute("cartList");
		for(int i=0;i<sc2.size();i++){
			if(sc2.get(i).getId()==scid){
				sc2.remove(i);
			}
		}

		httpSession.setAttribute("cartList",sc2);
		return "true";

	}

	/**
	 * 支付功能
	 * @param password	支付密码
	 * @param id	购物车id
	 * @param httpSession	session
	 * @return	ajax的提示信息
	 */
	@RequestMapping(value = "/pay.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String Pay(String password,String id,HttpSession httpSession){
		System.out.println("password:"+password+"id:"+id);
//		获取用户ID
		int uid=(Integer)httpSession.getAttribute("userId");
//		验证支付密码是否正确
		System.out.println("----"+uid);


		Wallet wallet=iWalletService.findById(uid);

// 		如果密码正确则判断钱包金额是否大于或等于待支付的金额
		if(wallet.getPassword()==Integer.parseInt(password)){

//		通过Id查询购物商品的金额
		ShoppingCart shoppingCart3=iShoppingCartService.findOnlyOne(Integer.parseInt(id));

//		如果钱包金额大于支付额就进行相减操作
		if(shoppingCart3.getTotalMoney()<=wallet.getMoney()){

			wallet.setMoney(wallet.getMoney()-shoppingCart3.getTotalMoney());
			iWalletService.updateMoney(wallet);
			System.out.println("金额支付成功！");
//			在订单表中添加一条数据
//			订单生成时间
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str=sdf.format(date);
			System.out.println("date:"+str);
			Order order=new Order();
			order.setUserId(uid);
			order.setMoney(shoppingCart3.getTotalMoney());
			order.setNumber(shoppingCart3.getNumber());
			System.out.println("插入时间");
			order.setDate(str);
			order.setGoodsId(shoppingCart3.getGoodsId());
			System.out.println("订单开始插入数据库");
//			插入订单表
			System.out.println(order.getDate()+"--"+order.getUserId()+"--"+order.getPrice());
			iOrderService.addOrder(order);
			System.out.println("插入订单成功！");

//			从购物车中删除一条数据
			iShoppingCartService.removeOfCart(Integer.parseInt(id));

//          从session中删除数据
			List<ShoppingCart> sc2=(List<ShoppingCart>) httpSession.getAttribute("cartList");

			for(int i=0;i<sc2.size();i++){
				if(sc2.get(i).getId()==Integer.parseInt(id)){
					sc2.remove(i);
				}
			}

				httpSession.removeAttribute("cartList");
				httpSession.setAttribute("cartList",sc2);
				return "true";


		}else {
			return "failed";
		}
		}
		return "false";
	}

	/**
	 * 展示购物车
	 * @param httpSession 获取购物车商品信息添加至session
	 * @return 跳转至checkout.jsp
	 */
	@RequestMapping("/showCheckout.do")
	public String showCheckout(HttpSession httpSession){
		int uid=(Integer)httpSession.getAttribute("userId");
		if(httpSession.getAttribute("cartList")!=null){
			return "redirect:checkout.jsp";
		}else{
			//从数据库查找数据并发送到session
			List<ShoppingCart> sc=iShoppingCartService.findById(uid);
			System.out.println("添加到数据库");

			//创建临时仓库
			List<Goods> goods =iGoodsService.findAll();

			for (Goods g:goods) {
				for (ShoppingCart shoppingCart:sc) {
					if(shoppingCart.getGoodsId()==g.getId()){
						shoppingCart.setGoodsName(g.getName());
						shoppingCart.setgPicture(g.getPicture());
						shoppingCart.setGoodsPrice(g.getPrice());
					}
				}
			}

			if(sc!=null){
				httpSession.setAttribute("cartList",sc);
				return "redirect:checkout.jsp";
			}
		}
			return "redirect:404.html";
	}
}

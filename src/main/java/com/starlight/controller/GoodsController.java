package com.starlight.controller;

import com.starlight.entity.Goods;
import com.starlight.service.IGoodsService;
import com.starlight.service.IOpinionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 * 商品控制类：对商品业务进行控制
 */
@Controller
public class GoodsController {

	/**商品业务*/
	@Resource
	private IGoodsService iGoodsService;

	/**商品意见业务*/
	@Resource
	private IOpinionService iOpinionService;

	/**
	 * 如果有商品就获取商品，如果没有就返回404错误
	 * @param httpSession 创建商品session
	 * @return 跳转页面至 products.jsp
	 */
	@RequestMapping("/products.do")
	public String getGoods(HttpSession httpSession){
		System.out.print("进入商品");
		List<Goods> list =iGoodsService.findAll();

		if(list!=null){
			httpSession.setAttribute("showAllGoods",list);
			return "redirect:products.jsp";
			}
			return "redirect:404.html";
	}

	/**
	 * 获取商品详细信息并跳转到商品详细页面
	 * @param id 商品id
	 * @param httpSession	session
	 * @return	跳转页面至single.jsp
	 */
	@RequestMapping("/single.do")
	public String getGoodsInfo(int id,HttpSession httpSession){
		System.out.print("id:"+id);
		List<Goods> list=(List<Goods>)httpSession.getAttribute("showAllGoods");
		for (Goods g:
		     list) {
			if(g.getId()==id){
				httpSession.setAttribute("onlyGoods",g);
				if(iOpinionService.findGoodsOpinion(g.getId())!=null){
					httpSession.setAttribute("opinion",iOpinionService.findGoodsOpinion(g.getId()));
				}
				return "redirect:single.jsp";
			}
		}
		return "redirect:404.html";
	}

}

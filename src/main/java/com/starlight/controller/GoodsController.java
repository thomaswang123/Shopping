package com.starlight.controller;

import com.starlight.entity.Goods;
import com.starlight.serviceimp.GoodsServiceImp;
import com.starlight.serviceimp.OpinionServiceImp;
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
	@Resource
	private GoodsServiceImp goodsServiceImp;
	@Resource
	private OpinionServiceImp opinionServiceImp;

	/**
	 * 如果有商品就获取商品，如果没有就返回404错误
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/products.do")
	public String getGoods(HttpSession httpSession){
		System.out.print("进入商品");
		List<Goods> list =goodsServiceImp.findAll();

		if(list!=null){
			httpSession.setAttribute("showAllGoods",list);
			return "redirect:products.jsp";
			}
			return "redirect:404.html";
	}

	/**
	 * 获取商品详细信息并跳转到商品详细页面
	 * @param id
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/single.do")
	public String getGoodsInfo(int id,HttpSession httpSession){
		System.out.print("id:"+id);
		List<Goods> list=(List<Goods>)httpSession.getAttribute("showAllGoods");
		for (Goods g:
		     list) {
			if(g.getId()==id){
				httpSession.setAttribute("onlyGoods",g);
				if(opinionServiceImp.findGoodsOpinion(g.getId())!=null){
					httpSession.setAttribute("opinion",opinionServiceImp.findGoodsOpinion(g.getId()));
				}
				return "redirect:single.jsp";
			}
		}
		return "redirect:404.html";
	}

}

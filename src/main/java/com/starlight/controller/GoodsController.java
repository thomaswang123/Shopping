package com.starlight.controller;

import com.starlight.entity.Goods;
import com.starlight.serviceimp.GoodsServiceImp;
import com.starlight.serviceimp.OpinionServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by james.jiang on 2016/12/23.
 * 商品控制类：对商品业务进行控制
 */
@Controller
public class GoodsController {
	@Resource
	Goods goods;
	@Resource
	GoodsServiceImp goodsServiceImp;
	@Resource
	OpinionServiceImp opinionServiceImp;
	@Resource
	List<Goods> li;
	@RequestMapping("/products.do")
	public String getGoods(HttpSession httpSession,
	                       HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		System.out.print("进入商品");
		List<Goods> list =goodsServiceImp.findAll();

		if(list!=null){
			httpSession.setAttribute("showAllGoods",list);
			return "redirect:products.jsp";
			}
			return "";
	}

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
		return "";
	}



}

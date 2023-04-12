package com.himedia.shop01.goods.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface GoodsController {

	public ModelAndView goodsDetail(String goods_id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}

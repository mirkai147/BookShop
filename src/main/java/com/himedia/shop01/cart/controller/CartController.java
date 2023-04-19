package com.himedia.shop01.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CartController {

	public String addGoodsInCart(int goods_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView myCartMain(HttpServletRequest request, HttpServletResponse response) throws Exception;

}

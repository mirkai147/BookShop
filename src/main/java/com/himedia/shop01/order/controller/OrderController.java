package com.himedia.shop01.order.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.himedia.shop01.order.vo.OrderVO;

public interface OrderController {

	public ModelAndView orderEachGoods(OrderVO _orderVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView payToOrderGoods(Map<String, String> receiverMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView orderAllCartGoods(String[] cart_goods_qty, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}

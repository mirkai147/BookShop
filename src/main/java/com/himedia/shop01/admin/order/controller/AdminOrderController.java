package com.himedia.shop01.admin.order.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public interface AdminOrderController {

	ModelAndView adminOrderMain(Map<String, String> dataMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	ResponseEntity modifyDeliveryState(Map<String, String> deliveryMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	ModelAndView orderDetail(int order_id, HttpServletRequest request, HttpServletResponse response) throws Exception;

}

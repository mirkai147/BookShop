package com.himedia.shop01.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MyPageController {

	public ModelAndView myPageMain(String message, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView cancelMyOrder(String order_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}

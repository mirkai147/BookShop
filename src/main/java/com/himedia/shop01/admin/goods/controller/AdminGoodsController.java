package com.himedia.shop01.admin.goods.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface AdminGoodsController {

	public ModelAndView adminGoodsMain(Map<String, String> dataMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ResponseEntity addNewGoods(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	public ModelAndView modifyGoodsForm(int goods_id, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ResponseEntity modifyGoodsInfo(String goods_id, String attribute, String value, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}

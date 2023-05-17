package com.himedia.shop01.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminMemberController {

	ModelAndView adminMemberMain(Map<String, String> dataMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

}

package com.himedia.shop01.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminMemberController {

	public ModelAndView adminMemberMain(Map<String, String> dataMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public void modifyMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

}

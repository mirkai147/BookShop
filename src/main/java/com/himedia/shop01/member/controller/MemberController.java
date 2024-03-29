package com.himedia.shop01.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.himedia.shop01.member.vo.MemberVO;

public interface MemberController {

	public ModelAndView login(Map<String, String> loginMap, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ResponseEntity overlapped(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity addMember(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	
}

package com.himedia.shop01.member.service;

import java.util.List;
import java.util.Map;

import com.himedia.shop01.goods.vo.GoodsVO;
import com.himedia.shop01.member.vo.MemberVO;

public interface MemberService {

	public MemberVO login(Map loginMap) throws Exception;

	public String overlapped(String id) throws Exception;

	public void addMember(MemberVO memberVO) throws Exception;

}

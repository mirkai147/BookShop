package com.himedia.shop01.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.himedia.shop01.member.vo.MemberVO;

public interface AdminMemberService {

	ArrayList<MemberVO> listMember(HashMap condMap) throws Exception;

}

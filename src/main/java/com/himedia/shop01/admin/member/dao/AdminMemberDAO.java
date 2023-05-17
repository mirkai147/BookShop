package com.himedia.shop01.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.member.vo.MemberVO;

public interface AdminMemberDAO {

	ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException;

}

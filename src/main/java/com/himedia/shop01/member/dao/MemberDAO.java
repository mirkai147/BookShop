package com.himedia.shop01.member.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.member.vo.MemberVO;

public interface MemberDAO {

	public MemberVO login(Map login) throws DataAccessException;

	public String selectOverlappedID(String id) throws DataAccessException;

	public void insertNewMember(MemberVO memberVO) throws DataAccessException;

	
}

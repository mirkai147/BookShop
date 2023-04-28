package com.himedia.shop01.mypage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.member.vo.MemberVO;
import com.himedia.shop01.order.vo.OrderVO;

public interface MyPageDAO {

	public List<OrderVO> selectMyOrderGoodsList(String member_id) throws DataAccessException;

	public void updateMyOrderCancel(String order_id) throws DataAccessException;

	public void updateMyInfo(Map memberMap) throws DataAccessException;

	public MemberVO selectMyDetailInfo(String member_id) throws DataAccessException;

}

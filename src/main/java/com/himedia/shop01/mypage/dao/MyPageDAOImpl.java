package com.himedia.shop01.mypage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.himedia.shop01.member.vo.MemberVO;
import com.himedia.shop01.order.vo.OrderVO;

@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<OrderVO> selectMyOrderGoodsList(String member_id) throws DataAccessException {
		List<OrderVO> orderGoodsList = sqlSession.selectList("mapper.mypage.selectMyOrderGoodsList", member_id);
		return orderGoodsList;
	}
	
	@Override
	public void updateMyOrderCancel(String order_id) throws DataAccessException {
		sqlSession.update("mapper.mypage.updateMyOrderCancel", order_id);
	}
	
	@Override
	public void updateMyInfo(Map memberMap) throws DataAccessException {
		sqlSession.update("mapper.mypage.updateMyInfo", memberMap);
	}
	
	@Override
	public MemberVO selectMyDetailInfo(String member_id) throws DataAccessException {
		MemberVO memberVO = sqlSession.selectOne("mapper.mypage.selectMyDetailInfo", member_id);
		return memberVO;
	}
}

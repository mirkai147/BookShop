package com.himedia.shop01.admin.order.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.himedia.shop01.member.vo.MemberVO;
import com.himedia.shop01.order.vo.OrderVO;

@Repository("adminOrderDAO")
public class AdminOrderDAOImpl implements AdminOrderDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<OrderVO> selectNewOrderList(Map condMap) throws DataAccessException {
		ArrayList<OrderVO> orderList = (ArrayList) sqlSession.selectList("mapper.admin.order.selectNewOrderList", condMap);
		return orderList;
	}
	
	@Override
	public void updateDeliveryState(Map deliveryMap) throws DataAccessException {
		sqlSession.update("mapper.admin.order.updateDeliveryState", deliveryMap);
	}
	
	@Override
	public ArrayList<OrderVO> selectOrderDetail(int order_id) throws DataAccessException {
		ArrayList<OrderVO> orderList = (ArrayList) sqlSession.selectList("mapper.admin.order.selectOrderDetail", order_id);
		return orderList;
	}
	
	@Override
	public MemberVO selectOrderer(String member_id) throws DataAccessException {
		MemberVO orderer = (MemberVO) sqlSession.selectOne("mapper.admin.order.selectOrderer", member_id);
		return orderer;
	}
}

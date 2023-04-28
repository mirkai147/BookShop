package com.himedia.shop01.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

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
}

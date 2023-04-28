package com.himedia.shop01.mypage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.order.vo.OrderVO;

public interface MyPageDAO {

	public List<OrderVO> selectMyOrderGoodsList(String member_id) throws DataAccessException;

	public void updateMyOrderCancel(String order_id) throws DataAccessException;

}

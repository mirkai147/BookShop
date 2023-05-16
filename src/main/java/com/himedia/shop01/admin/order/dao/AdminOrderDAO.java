package com.himedia.shop01.admin.order.dao;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.member.vo.MemberVO;
import com.himedia.shop01.order.vo.OrderVO;

public interface AdminOrderDAO {

	ArrayList<OrderVO> selectNewOrderList(Map condMap) throws DataAccessException;

	void updateDeliveryState(Map deliveryMap) throws DataAccessException;

	ArrayList<OrderVO> selectOrderDetail(int order_id) throws DataAccessException;

	MemberVO selectOrderer(String member_id) throws DataAccessException;

}

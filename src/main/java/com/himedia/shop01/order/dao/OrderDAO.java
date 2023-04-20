package com.himedia.shop01.order.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.order.vo.OrderVO;

public interface OrderDAO {

	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException;

	public void removeGoodsFromCart(List<OrderVO> myOrderList) throws DataAccessException;

}

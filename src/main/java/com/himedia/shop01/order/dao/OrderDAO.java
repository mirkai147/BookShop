package com.himedia.shop01.order.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.order.vo.OrderVO;

public interface OrderDAO {

	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException;

	public void removeGoodsFromCart(List<OrderVO> myOrderList) throws DataAccessException;

	public void removeGoodsFromCart(OrderVO orderVO) throws DataAccessException;

	public OrderVO findMyOrder(String order_id) throws DataAccessException;

	public int selectOrderID() throws DataAccessException;

	public List<OrderVO> listMyOrderGoods(OrderVO orderVO) throws DataAccessException;

}

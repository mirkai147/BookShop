package com.himedia.shop01.order.service;

import java.util.List;

import com.himedia.shop01.order.vo.OrderVO;

public interface OrderService {

	public void addNewOrder(List<OrderVO> myOrderList) throws Exception;

}

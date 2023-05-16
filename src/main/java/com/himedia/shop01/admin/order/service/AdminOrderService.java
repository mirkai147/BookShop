package com.himedia.shop01.admin.order.service;

import java.util.List;
import java.util.Map;

import com.himedia.shop01.order.vo.OrderVO;

public interface AdminOrderService {

	List<OrderVO> listNewOrder(Map condMap) throws Exception;

	void modifyDeliveryState(Map deliveryMap) throws Exception;

	Map orderDetail(int order_id) throws Exception;

}

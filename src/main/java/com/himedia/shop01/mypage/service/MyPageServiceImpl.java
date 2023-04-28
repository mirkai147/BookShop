package com.himedia.shop01.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.himedia.shop01.mypage.dao.MyPageDAO;
import com.himedia.shop01.order.vo.OrderVO;

@Service("myPageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MyPageServiceImpl implements MyPageService {
	
	@Autowired
	private MyPageDAO myPageDAO;
	
	@Override
	public List<OrderVO> listMyOrderGoods(String member_id) throws Exception {
		return myPageDAO.selectMyOrderGoodsList(member_id);
	}
	
	@Override
	public void cancelOrder(String order_id) throws Exception {
		myPageDAO.updateMyOrderCancel(order_id);
	}

}

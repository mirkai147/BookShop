package com.himedia.shop01.mypage.service;

import java.util.List;
import java.util.Map;

import com.himedia.shop01.member.vo.MemberVO;
import com.himedia.shop01.order.vo.OrderVO;

public interface MyPageService {

	public List<OrderVO> listMyOrderGoods(String member_id) throws Exception;

	public void cancelOrder(String order_id) throws Exception;

	public MemberVO modifyMyInfo(Map memberMap) throws Exception;

}

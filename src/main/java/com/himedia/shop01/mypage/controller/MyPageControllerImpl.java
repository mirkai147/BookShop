package com.himedia.shop01.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.himedia.shop01.common.base.BaseController;
import com.himedia.shop01.member.vo.MemberVO;
import com.himedia.shop01.mypage.service.MyPageService;
import com.himedia.shop01.order.vo.OrderVO;

@Controller("myPageController")
@RequestMapping("mypage")
public class MyPageControllerImpl extends BaseController implements MyPageController {

	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private MemberVO memberVO;

	@Override
	@RequestMapping(value = "/myPageMain.do", method = RequestMethod.GET)
	public ModelAndView myPageMain(@RequestParam(required = false, value = "message") String message,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("side_menu", "my_page");
				
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		
		memberVO = (MemberVO) session.getAttribute("memberInfo");
		String member_id = memberVO.getMember_id();
		List<OrderVO> myOrderList = myPageService.listMyOrderGoods(member_id);
		
		mav.addObject("message", message);
		mav.addObject("myOrderList", myOrderList);
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/cancelMyOrder", method = RequestMethod.POST)
	public ModelAndView cancelMyOrder(@RequestParam("order_id") String order_id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		myPageService.cancelOrder(order_id);
		mav.addObject("message", "cancel_order");
		mav.setViewName("redirect:/mypage/myPageMain.do");
		return mav;
	}
	
	
}

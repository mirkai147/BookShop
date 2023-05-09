package com.himedia.shop01.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.himedia.shop01.order.service.ApiService01;


@Controller
//@RequestMapping(value = "/test")
public class NaverController2 {

	@Autowired
	private ApiService01 apiService01;
	
	@RequestMapping(value = "/test/naverPay.do", method = RequestMethod.POST)
	public ModelAndView naverPay(@RequestParam Map<String,String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(map.toString());
		
// {ordr_idxx=20230502102210KK0644, good_name=????? ??????, good_mny=100, buyr_name=??????, site_cd=A8QOB, req_tx=pay, pay_method=100000000000, currency=410, kakaopay_direct=Y, module_type=01, ordr_chk=20230502102210KK0644|100, param_opt_1=, param_opt_2=, param_opt_3=, res_cd=0000, res_msg=????, enc_info=2n07b4sjVhu573QZVVa6xpRW1NWxiaeefRee2h2AuZFmnpNJfBFzTkqek0sRSJQRS8b3ZsmND9l7tY8AHU.pLCG3I4BNhhF0iAaQCzZJ2Ri2L82NxlzMdY-2K79yFOC3Ggoj6QbIicoF9HiENzDRbgzRMAK0BiOzRNn2.s4bg8ktMTDf0wCYorliQntxP5b0z3JRNwPd-ZJ__, enc_data=4B0en.FInO56Ed1YcnThGg7mYs3eUJ8LxZPoAjrUpgpLllBnPHri7KylfEdH9G0hArSZx.QWtinco9AN0Qj96IrBI1wbooV9US82oCgF6O8EaKWHuGTb8Ih4g9wgDyn6sMiGX4J1JXsoKAJxT93ah7ujDvFNrNbfZ64OzRD3DfSnl1WItvyRMW-2Y44O6LjOJOfK0-nUCR0Al5nauhUP8Cm76OmZPz1DbbPvoOyRk2zlDbyurSN6kBjNYx.VhsEVhq4CG5oUMARZXLI6Hy8puYjhOqVFYnLY2uHhsbH0ObFzd-3tff6sHoLPFpNExPMdaUSUSx6xQ10gPXoFD68qM0HSdfI.5c52i01MIGkcY07rWfqgs90pS4MVrCTinySBEc--nwQLX4xW0aCkK2tW8Zpw33HeP9Fekdq0.734S.uAflEqOcbF86wqWLdQFbDe4O6gEV3Y9MLnyKae2aovH0vjhAMk2AGi5MpueZoNSkuj.zYhi2B2waxhmATe5XcCgCjZr.RITM1MiMo5IyJay6BX5xZPv9JTg58.HKRmT1fQWaudHlvvK57T76EraU9TAbnMm5I.3uiMHtxWvwXxPho7DS9aDlENkwq5ujgn-4-WX6YUB2C0PHybsFg5DMwhm6sLtMeaqj8v9ws3wlWPMUM9HLd.IzreFHrwBKS02K8TCmk0EVWHTY8dMUdvS06OGj23iMoEWNfEA3qhIxGyCjax6aIdG2guW4WrMb-vMp82zznid5ls9yC8rq3kdl1.JkEpDzg.gIB-ILsxNCYFWxHQ3DY25M1tLu6-wqzT8GJN_, ret_pay_method=CARD, tran_cd=00100000, use_pay_method=100000000000, card_pay_method=KAKAO_CARD}

		
		//4. 인증 데이터로 결제 요청하기 (rest api 사용)
		// 내가 api 통신시 보내야되는(요청) 데이터 나열
		String res_cd = map.get("res_cd");
		String enc_info = map.get("enc_info");
		String enc_data = map.get("enc_data");
		String ordr_idxx = map.get("ordr_idxx");
		String tran_cd = map.get("tran_cd");
		
		
		Map<String,String> dataMap = new HashMap<String, String>();
		dataMap.put("res_cd", res_cd);
		dataMap.put("enc_info", enc_info);
		dataMap.put("enc_data", enc_data);
		dataMap.put("ordr_idxx", ordr_idxx);
		dataMap.put("tran_cd", tran_cd);
//		dataMap.put("card_pay_method", card_pay_method);
		
		
		//주문 연동 하기
		String id = "himedia"; //발급된 계정
		String base = "https://api.testpayup.co.kr";
		String path = "/ep/api/naver/"+id+"/pay";
		
		String url = base+path;
				
		//apiService01.restApi(/*여기에 맵(요청값들이 들어있어야함)*/ dataMap, /*URL (풀 URL)*/ url);
		Map<String,Object> resultMap = apiService01.restApi(dataMap, url);
		
		System.out.println("네이버페이 결제 응답 = " + resultMap.toString());
		
		//view 설정
		//승인 성공 or 실패
//		String responseCode = "0000"; //테스트
		String responseCode = (String) resultMap.get("responseCode");
		String responseMsg = (String) resultMap.get("responseMsg");
		String authDateTime = (String) resultMap.get("authDateTime");
		String amount = (String) resultMap.get("amount");
//		String authNumber = (String) resultMap.get("authNumber");
		
		mav.addObject("responseCode", responseCode);
		mav.addObject("responseMsg", responseMsg);
		mav.addObject("authDateTime", authDateTime);
		mav.addObject("amount", amount);
//		mav.addObject("authNumber", authNumber);
				
		// "0000" == responseCode <<(X)
		if("0000".equals(responseCode) || responseCode.equals("0000")) {
			//성공
			//페이지 설정
			mav.setViewName("/naver/naverResult");
		}else {
			//실패
			//페이지 설정
			mav.setViewName("/naver/naverResultFail");
		}
		
		return mav;
		
	}
}
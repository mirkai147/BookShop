package com.himedia.shop01.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.himedia.shop01.order.service.ApiService01;


@RestController
public class NaverController {

	@Autowired
	private ApiService01 apiService01;
	
	@RequestMapping(value= "/test/naverOrder.do")
	public Map<String,Object> naverOrder(@RequestParam Map<String, String> dateMap) throws Exception{
		
		
		System.out.println("������ ������ = " + dateMap.toString());
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//�ֹ� ���� �ϱ�
		String id = "himedia"; //�߱޵� ����
		String base = "https://api.testpayup.co.kr";
		String path = "/ep/api/naver/"+id+"/order";
		
		String url = base+path;
		
		String signature = ""; 
		
		//�Ķ���ͷ� ����� ��
		Map<String,String> map = new HashMap<String,String>();
		map.put("orderNumber","TEST_12346"); //�ֹ������� �����ؾ��� ����� Ű�� (������ ���ؼ� ���ǰ�)
//		map.put("amount",dateMap.get("amount")); //ȭ�鿡�� �޾ƿ� ��
		map.put("amount","100"); //ȭ�鿡�� �޾ƿ� �� (�׽�Ʈ�� ���ؼ� 100�� ����)
		map.put("itemName",dateMap.get("itemName")); //ȭ�鿡�� �޾ƿ� ��
//		map.put("userName",dateMap.get("userName")); //ȭ�鿡�� �޾ƿ� ��
		map.put("userName","�׽�Ʈ��"); //(�׽�Ʈ�� ���ؼ� ����)
		map.put("returnUrl","naver.com");//PC������ ���߿���
		map.put("timestamp","1000");
		map.put("userAgent","WP");
		map.put("payType", dateMap.get("payType"));
		
		signature = apiService01.encrypt(id+"|"+map.get("orderNumber")+"|"+map.get("amount")+"|ac805b30517f4fd08e3e80490e559f8e|"+map.get("timestamp"));
		
		map.put("signature",signature);
		resultMap = apiService01.restApi(map, url);
		System.out.println("������ ������ = " + resultMap.toString());
		
		return resultMap;
	}
}

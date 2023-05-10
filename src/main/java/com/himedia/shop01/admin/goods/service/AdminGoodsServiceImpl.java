package com.himedia.shop01.admin.goods.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.himedia.shop01.admin.goods.dao.AdminGoodsDAO;
import com.himedia.shop01.goods.vo.GoodsVO;
import com.himedia.shop01.goods.vo.ImageFileVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminGoodsServiceImpl implements AdminGoodsService {

	@Autowired
	private AdminGoodsDAO adminGoodsDAO;
	
	@Override
	public int addNewGoods(Map newGoodsMap) throws Exception {
		int goods_id = adminGoodsDAO.insertNewGoods(newGoodsMap);
		ArrayList<ImageFileVO> imageFileList = (ArrayList<ImageFileVO>) newGoodsMap.get("imageFileList");
		for(ImageFileVO imageFileVO : imageFileList) {
			imageFileVO.setGoods_id(goods_id);
		}
		adminGoodsDAO.insertGoodsImageFile(imageFileList);
		return goods_id;
	}
	
	@Override
	public List<GoodsVO> listNewGoods(Map condMap) throws Exception {
		return adminGoodsDAO.selectNewGoodsList(condMap);
	}
	
	@Override
	public Map goodsDetail(int goods_id) throws Exception {
		
		return null;
	}
}

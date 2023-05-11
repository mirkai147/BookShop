package com.himedia.shop01.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.himedia.shop01.goods.vo.GoodsVO;
import com.himedia.shop01.goods.vo.ImageFileVO;

public interface AdminGoodsService {

	public int addNewGoods(Map newGoodsMap) throws Exception;

	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;

	public Map goodsDetail(int goods_id) throws Exception;

	public void modifyGoodsInfo(Map goodsMap) throws Exception;

	public void modifyGoodsImage(List<ImageFileVO> imageFileList) throws Exception;

	public void addNewGoodsImage(List imageFileList) throws Exception;

	public void removeGoodsImage(int image_id) throws Exception;

}

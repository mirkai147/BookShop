package com.himedia.shop01.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.himedia.shop01.goods.vo.GoodsVO;

public interface AdminGoodsService {

	public int addNewGoods(Map newGoodsMap) throws Exception;

	public List<GoodsVO> listNewGoods(Map condMap) throws Exception;

	public Map goodsDetail(int goods_id) throws Exception;

}

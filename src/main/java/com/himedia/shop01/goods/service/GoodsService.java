package com.himedia.shop01.goods.service;

import java.util.List;
import java.util.Map;

import com.himedia.shop01.goods.vo.GoodsVO;

public interface GoodsService {

	public Map<String, List<GoodsVO>> listGoods() throws Exception;

	public Map goodsDetail(String _goods_id) throws Exception;

	public List keywordSearch(String keyword) throws Exception;

	public List searchGoods(String keyword) throws Exception;

}

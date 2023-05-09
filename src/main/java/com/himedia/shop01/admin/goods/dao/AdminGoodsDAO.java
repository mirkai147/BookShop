package com.himedia.shop01.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.goods.vo.GoodsVO;

public interface AdminGoodsDAO {

	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	public void insertGoodsImageFile(List imageFileList) throws DataAccessException;

	public List<GoodsVO> selectNewGoodsList(Map condMap) throws DataAccessException;

}

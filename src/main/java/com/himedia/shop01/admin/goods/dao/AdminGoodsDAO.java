package com.himedia.shop01.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.goods.vo.GoodsVO;
import com.himedia.shop01.goods.vo.ImageFileVO;

public interface AdminGoodsDAO {

	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	public void insertGoodsImageFile(List imageFileList) throws DataAccessException;

	public List<GoodsVO> selectNewGoodsList(Map condMap) throws DataAccessException;

	public void updateGoodsInfo(Map goodsMap) throws DataAccessException;

	public void updateGoodsImage(List<ImageFileVO> imageFileList) throws DataAccessException;

	public GoodsVO selectGoodsDetail(int goods_id) throws DataAccessException;

	public List selectGoodsImageFileList(int goods_id) throws DataAccessException;

	public void deleteGoodsImage(int image_id) throws DataAccessException;

}

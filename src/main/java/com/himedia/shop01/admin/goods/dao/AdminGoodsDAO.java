package com.himedia.shop01.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface AdminGoodsDAO {

	public int insertNewGoods(Map newGoodsMap) throws DataAccessException;

	public void insertGoodsImageFile(List imageFileList) throws DataAccessException;

}

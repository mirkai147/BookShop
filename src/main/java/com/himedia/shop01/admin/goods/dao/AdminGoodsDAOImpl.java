package com.himedia.shop01.admin.goods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.himedia.shop01.goods.vo.ImageFileVO;

@Repository("adminGoodsDAO")
public class AdminGoodsDAOImpl implements AdminGoodsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewGoods(Map newGoodsMap) throws DataAccessException {
		sqlSession.insert("mapper.admin.goods.insertNewGoods", newGoodsMap);
		return Integer.parseInt((String) newGoodsMap.get("goods_id"));
	}
	
	@Override
	public void insertGoodsImageFile(List imageFileList) throws DataAccessException {
		for(int i=0; i<imageFileList.size(); i++) {
			ImageFileVO imageFileVO = (ImageFileVO) imageFileList.get(i);
			sqlSession.insert("mapper.admin.goods.insertGoodsImageFile", imageFileVO);
		}
	}
}

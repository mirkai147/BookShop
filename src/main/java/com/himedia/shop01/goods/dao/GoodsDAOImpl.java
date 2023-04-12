package com.himedia.shop01.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.himedia.shop01.goods.vo.GoodsVO;
import com.himedia.shop01.goods.vo.ImageFileVO;

@Repository("goodsDAO")
public class GoodsDAOImpl implements GoodsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<GoodsVO> selectGoodsList(String goodsStatus) throws DataAccessException {
		List<GoodsVO> goodsList = (ArrayList)sqlSession.selectList("mapper.goods.selectGoodsList", goodsStatus);
		return goodsList;
	}
	
	@Override
	public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException {
		GoodsVO goodsVO = (GoodsVO) sqlSession.selectOne("mapper.goods.selectGoodsDetail", goods_id);
		return goodsVO;
	}
	
	@Override
	public List<ImageFileVO> selectGoodsDetailImage(String goods_id) throws DataAccessException {
		List<ImageFileVO> imageList = (ArrayList) sqlSession.selectList("mapper.goods.selectGoodsDetailImage", goods_id);
		return imageList;
	}
	
}

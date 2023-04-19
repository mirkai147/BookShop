package com.himedia.shop01.cart.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.himedia.shop01.cart.vo.CartVO;
import com.himedia.shop01.goods.vo.GoodsVO;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.cart.selectCountInCart", cartVO);
		return Boolean.parseBoolean(result);
	}
	
	@Override
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException {
		int cart_id = selectMaxCartId();
		cartVO.setCart_id(cart_id);
		sqlSession.insert("mapper.cart.insertGoodsInCart", cartVO);
	}

	@Override
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException {
		List<CartVO> cartList = sqlSession.selectList("mapper.cart.selectCartList", cartVO);
		return cartList;
	}
	
	@Override
	public List<GoodsVO> selectGoodsList(List<CartVO> myCartList) throws DataAccessException {
		List<GoodsVO> goodsList = sqlSession.selectList("mapper.cart.selectGoodsList", myCartList);
		return goodsList;
	}
	

	private int selectMaxCartId() throws DataAccessException {
		int cart_id = sqlSession.selectOne("mapper.cart.selectMaxCartId");
		return cart_id;
	}
}

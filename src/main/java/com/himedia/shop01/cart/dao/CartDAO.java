package com.himedia.shop01.cart.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.cart.vo.CartVO;
import com.himedia.shop01.goods.vo.GoodsVO;

public interface CartDAO {

	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;

	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException;

	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException;

	public List<GoodsVO> selectGoodsList(List<CartVO> myCartList) throws DataAccessException;

}

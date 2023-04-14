package com.himedia.shop01.cart.dao;

import org.springframework.dao.DataAccessException;

import com.himedia.shop01.cart.vo.CartVO;

public interface CartDAO {

	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;

	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException;

}

package com.himedia.shop01.cart.service;

import com.himedia.shop01.cart.vo.CartVO;

public interface CartService {

	public boolean findCartGoods(CartVO cartVO) throws Exception;

	public void addGoodsInCart(CartVO cartVO) throws Exception;

}

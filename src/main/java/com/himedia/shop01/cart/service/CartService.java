package com.himedia.shop01.cart.service;

import java.util.List;
import java.util.Map;
import com.himedia.shop01.cart.vo.CartVO;

public interface CartService {

	public boolean findCartGoods(CartVO cartVO) throws Exception;

	public void addGoodsInCart(CartVO cartVO) throws Exception;

	public Map<String, List> myCartList(CartVO cartVO) throws Exception;

}

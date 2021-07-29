package com.koreait.shoppingmall.controller.rest.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.shoppingmall.domain.Cart;
import com.koreait.shoppingmall.model.service.product.CartService;


@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	
	//장바구니에 1건 담기
	@PostMapping("/cart")  //RESTful 하다, 즉 rest를 준수함
	public String insert(@RequestBody Cart cart) { //json 으로 받아야 함 &~~~,
		//cartService.insert(cart);
		
		return "장바구니 넣기 결과";
	}
}

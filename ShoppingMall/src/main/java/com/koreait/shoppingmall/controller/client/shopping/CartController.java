package com.koreait.shoppingmall.controller.client.shopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.model.service.product.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	//장바구니 목록 가져오기 
	@GetMapping("/cart/list")  //  
	public ModelAndView getList(HttpServletRequest request) {
		//방법) 매개변수 없이 client/cart/list aop  세션체크 후, 세션이 존재하면 proceed() 시켜 세션으로부터
		//회원정보를 프로그래밍 적으로 얻어와 매개변수에 대입
		//Member member=request.getSession().getAttribute("member");
		//3단계: 일 시키기
		List cartList=cartService.selectAllJoin(1);
		
		//4단계:저장
		ModelAndView mav = new ModelAndView("client/shop/cart");
		mav.addObject("cartList", cartList);  
		
		return mav;
	}
}






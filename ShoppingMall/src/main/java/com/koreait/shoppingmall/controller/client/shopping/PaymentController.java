package com.koreait.shoppingmall.controller.client.shopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.model.repository.payment.PayMethodService;
import com.koreait.shoppingmall.model.service.product.CartService;

@Controller
public class PaymentController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PayMethodService payMethodService;
	
	
	//결제 페이지 요청 처리 
	@GetMapping("/checkout/form")
	public ModelAndView getForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("client/shop/checkout");
		//장바구니 목록 가져가야 함..
		//HttpSession session=request.getSession();
		//Member member=(Member)session.getAttribute("member");
		//cartService.selectAllJoin(member.getMember_id());
		List cartList=cartService.selectAllJoin(1);
		mav.addObject("cartList", cartList);
		
		//결제 방법 담기 
		List payMethodList = payMethodService.selectAll();
		mav.addObject("payMethodList", payMethodList);
		
		return mav;
	}
}

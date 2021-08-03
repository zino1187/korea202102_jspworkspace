package com.koreait.shoppingmall.controller.client.shopping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {
	
	//결제 페이지 요청 처리 
	@GetMapping("/checkout/form")
	public ModelAndView getForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("client/shop/checkout");
		return mav;
	}
}

package com.koreait.shoppingmall.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//관리자모드의 주문관리 관련 요청 컨트롤러
@Controller
public class OrderController {
	
	@GetMapping("/order/list")
	public String getList(int b, HttpSession session,String a) { //HttpServletRequest가 눈에 보이지 않는다고 하여, 매개변수로 넘어오지 않은 것이 아니다..
		//즉 개발자가 원할때는 매개변수에 HttpServletRequest, HttpSession를 명시할 수 있다..
		
		return "admin/order/order_list";
	}

}

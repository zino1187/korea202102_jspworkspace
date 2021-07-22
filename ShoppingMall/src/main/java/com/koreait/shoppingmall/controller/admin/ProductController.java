package com.koreait.shoppingmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//상품관련 요청을 처리하는 하위 컨트롤러
@Controller
public class ProductController {
	
	//상품 등록폼 요청처리 
	@GetMapping("/product/registform")
	public String registForm() {
		return "admin/product/regist";//상품 등록 폼 뷰이름
	}
}

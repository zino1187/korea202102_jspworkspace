package com.koreait.shoppingmall.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.shoppingmall.model.service.category.TopCategoryService;

//상품관련 요청을 처리하는 하위 컨트롤러
@Controller
public class ProductController {
	@Autowired
	private TopCategoryService topCategoryService;	
	
	//상품 등록폼 요청처리 
	@GetMapping("/product/registform")
	public String registForm(Model model) {
		//3단계: 최상위 카테고리 가져오기 
		List topList = topCategoryService.selectAll();
		
		//4단계:결과저장 
		model.addAttribute("topList", topList);
		
		return "admin/product/regist";//상품 등록 폼 뷰이름
	}
	
	//상품 등록 요청(파일업로드가 포함되어 있슴)
	@PostMapping("/product/regist")
	public String regist() {
		System.out.println("regist() 메서드 호출함");
		return null;
	}
	
}










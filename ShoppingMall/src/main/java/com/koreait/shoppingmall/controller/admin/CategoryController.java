package com.koreait.shoppingmall.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.shoppingmall.model.service.category.TopCategoryService;

//관리자가 보게될 상품의 카테고리와 관련된 요청처리 하위컨트롤러
@Controller
public class CategoryController {

	@Autowired
	private TopCategoryService topCategoryService;
	
	//카테고리 목록 
	@RequestMapping(value="/category/list", method=RequestMethod.GET)
	public String getCategoryList(Model model) {
		System.out.println("getCategoryList 호출");
		
		//3단계: 일 시키기
		List topList=topCategoryService.getSubCount();
		
		//4단계: 결과저장
		model.addAttribute("topList", topList);
		
		
		return "admin/category/index";
	}
	
}













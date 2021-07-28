package com.koreait.shoppingmall.controller.client;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.shoppingmall.model.service.category.TopCategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("msg", "클라이언트의 요청 테스트");
		return "home";  // 
	}
	
	//클라이언트의 메인 요청 
	@GetMapping("/main")
	public String getMain(Model model) {
		//최상위 카테고리 담아가야 함 
		
		//3단계: 일 시키기 
		List topList = topCategoryService.selectAll();
		
		//4단계: 저장(forwarding)
		model.addAttribute("topList", topList);
		
		return "client/index";
	}
	
	//상품리스트 페이지 요청
	@GetMapping("/shop/list")
	public String getList(Model model) {
		//3단계: 일 시키기 
		List topList = topCategoryService.selectAll();
		
		//4단계: 저장(forwarding)
		model.addAttribute("topList", topList);
		
		return "client/shop/main";
	}
}












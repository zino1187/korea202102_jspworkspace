package com.koreait.shoppingmall.controller.client.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/cs/board/main")
	public String boardMain() {
		
		return "client/board/index";
	}
}

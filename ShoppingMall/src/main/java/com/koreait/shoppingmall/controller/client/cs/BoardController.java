package com.koreait.shoppingmall.controller.client.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.shoppingmall.domain.Board;
import com.koreait.shoppingmall.model.service.cs.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/cs/board/main")
	public String boardMain() {
		
		return "client/board/index";
	}
	
	//글등록 요청 처리 
	@PostMapping("/cs/board/regist")
	public String regist(@RequestParam Board board) {
		System.out.println(board.getTitle());
		System.out.println(board.getWriter());
		System.out.println(board.getContent());
		
		return null;
	}
	
}








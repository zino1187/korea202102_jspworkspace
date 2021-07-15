package com.koreait.springmvc0715.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//목록, 등록, 수정, 삭제, 상세보기를 하나의 컨트롤러에서 처리~~~

@Controller
public class BoardController {
	
	//목록 요청을 처리하는 메서드 
	@RequestMapping("/board/list")
	public String getList() {
		System.out.println("목록을 원하는 군여");
		return null;
	}
	
}

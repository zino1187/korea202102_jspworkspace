package com.koreait.springdb.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  //스프링의 컴포넌트 스캔의 대상이 되기 위해..
public class BoardController {
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		System.out.println("클라이언트의 test() 호출");
		return null;
	}
	
	//게시판 목록 요청을 처리 
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList() {
		
		return null;
	}
	
	
}

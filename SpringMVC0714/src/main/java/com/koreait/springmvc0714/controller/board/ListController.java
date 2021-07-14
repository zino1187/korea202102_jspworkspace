package com.koreait.springmvc0714.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.model.board.service.BoardService;

import lombok.Setter;

//목록 요청을 처리하는 하위 컨트롤러 ( 3단계-일시키기 , 4단계-결과저장)
@Setter
public class ListController implements Controller{
	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계: 일 시키기 
		List boardList = boardService.selectAll();
		
		//4단계:결과 저장
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList", boardList);
		
		return mav;
	}
	
}




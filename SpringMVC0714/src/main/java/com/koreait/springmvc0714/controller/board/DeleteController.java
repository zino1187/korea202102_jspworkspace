package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;

import lombok.Setter;

//삭제 요청을 처리하는 하위 컨트롤러
@Setter
public class DeleteController implements Controller{
	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		try {
			boardService.delete(Integer.parseInt(request.getParameter("board_id")));//3단계: 일 시키기
			mav.setViewName("redirect:/board/list"); //목록으로 재접속을 유도 (redirect) 
		}catch(DMLException e) {
			e.printStackTrace();
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}
		return mav;
	}
}

package com.koreait.model2app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

//게시판의 상세보기 요청을 처리하는 하위 컨트롤러 
public class DetailController implements Controller{
	BoardDAO boardDAO;
	
	//3단계: 알맞는 객체에게 일시키기 
	//4단계: 클라이언에게 보여줄 결과가 잇다면, 형님 컨트롤러와 공유가 가능한 형태로 저장(request, session)
	public DetailController() {
		//boardDAO =new MybatisBoardDAO();
		boardDAO = new JdbcBoardDAO();
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String board_id=request.getParameter("board_id"); //파라미터 받기 
		
		Board board=boardDAO.select(Integer.parseInt(board_id));
		//4단계: 결과 저장(결과 jsp가 꺼낼 수 있도록) 
		request.setAttribute("board", board);
	}

	public String getViewName() {
		return "/result/board/detail";
	}
	public boolean isForward() {
		return true;
	}
	
}

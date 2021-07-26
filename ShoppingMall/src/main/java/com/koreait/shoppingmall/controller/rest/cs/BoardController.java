package com.koreait.shoppingmall.controller.rest.cs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.shoppingmall.domain.Board;
import com.koreait.shoppingmall.exception.DMLException;
import com.koreait.shoppingmall.model.service.cs.BoardService;

//게시판 rest 요청을 처리하는 하위 컨트롤러  
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//글목록
	@GetMapping("/board")
	@ResponseBody
	public List<Board> getList(){
		List boardList = boardService.selectAll();
		return boardList;
	}
	
	//글상세 
	@GetMapping("/board/{board_id}")
	@ResponseBody
	public Board getDetail(@PathVariable int board_id) { //{board_id}를 url경로의 일부로 보지말고, 변수로 인식시킴
		return boardService.select(board_id);
	}
	
	//글등록 
	@PostMapping("/board")
	public String regist(@RequestBody Board board) { //json 과의 매핑 때문에..
		boardService.insert(board);
		return "ok";
	}  
	
	//글수정
	
	//글삭제
	
	@ExceptionHandler(DMLException.class)
	public String handle(DMLException e) {
		return e.getMessage();
	}
}






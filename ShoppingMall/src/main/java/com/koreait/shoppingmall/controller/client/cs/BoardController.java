package com.koreait.shoppingmall.controller.client.cs;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.shoppingmall.domain.Board;
import com.koreait.shoppingmall.exception.DMLException;
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
	@ResponseBody //jsp 뷰페이지가 아닌 데이터를 클라이언트에게 전송
	public String regist(@RequestBody String data) {
		System.out.println(data);
		
		//데이터 파싱후 파라미터 출력
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject json=(JSONObject)jsonParser.parse(data);//파싱 후 객체반환
			
			System.out.println(json.get("title"));
			System.out.println(json.get("writer"));
			System.out.println(json.get("content"));
			
			Board board = new Board();
			board.setTitle((String)json.get("title"));
			board.setWriter((String)json.get("writer"));
			board.setContent((String)json.get("content"));
			
			boardService.insert(board); //등록
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "1";
	}
	
	@ExceptionHandler(DMLException.class)
	@ResponseBody
	public String handleException(DMLException e) {
		return e.getMessage();
	}
}











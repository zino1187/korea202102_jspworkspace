package com.koreait.springmvc0714.model.board.service;

import java.util.List;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.repository.BoardDAO;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

//서비스를 구현한 객체
@Setter
public class BoardServiceImpl implements BoardService{
	private BoardDAO boardDAO;//스프링의 컨테이너로 부터 주입받자!! (DI)
	
	@Override
	public List selectAll() {
		System.out.println("서비스의 selectAll() 호출");
		//서비스에서 리스트 반환처리하세요 
		return boardDAO.selectAll();
	}
	@Override
	public void insert(Board board) throws DMLException{
		boardDAO.insert(board);
	}
	@Override
	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}

	@Override
	public void update(Board board) throws DMLException{
		boardDAO.update(board);
	}

	@Override
	public void delete(int board_id) throws DMLException{
		boardDAO.delete(board_id);
	}
	
}

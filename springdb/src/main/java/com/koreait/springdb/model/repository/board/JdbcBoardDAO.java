package com.koreait.springdb.model.repository.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.springdb.model.domain.Board;

@Repository
public class JdbcBoardDAO  implements BoardDAO{

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board select(int board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int board_id) {
		// TODO Auto-generated method stub
		
	}

}

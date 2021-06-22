package com.koreait.site0622.model.board.dao;

import com.koreait.site0622.model.domain.Board;

//mybatis 를 이용한다고 하여 DAO가 사라지는게 아니라, DAO의 역할은 그래도 유지
//단, DAO가 사용하려는 기술이 JDBC, Mybatis, Hibernate, JPA 등등...인 것뿐
public class MybatisBoardDAO {
	
	//등록
	public int insert(Board board) {
		return 0;
	}
	
	
	
}

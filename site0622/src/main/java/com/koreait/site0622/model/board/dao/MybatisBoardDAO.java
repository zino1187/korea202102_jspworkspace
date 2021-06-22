package com.koreait.site0622.model.board.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Board;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

//mybatis 를 이용한다고 하여 DAO가 사라지는게 아니라, DAO의 역할은 그래도 유지
//단, DAO가 사용하려는 기술이 JDBC, Mybatis, Hibernate, JPA 등등...인 것뿐
public class MybatisBoardDAO {
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	
	//등록
	public int insert(Board board) {
		SqlSession sqlSession=configManager.getSession();
		int result=sqlSession.insert("Board.insert", board);
		sqlSession.commit();
		return result;
	}
	
	//모든 레코드 가져오기 
	public List selectAll() {
		SqlSession sqlSession=configManager.getSession();
		List list=sqlSession.selectList("Board.selectAll");
		return list;
	}
	
}








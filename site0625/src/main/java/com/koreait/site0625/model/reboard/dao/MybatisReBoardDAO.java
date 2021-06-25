package com.koreait.site0625.model.reboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.mybatis.MybatisConfigManager;

public class MybatisReBoardDAO implements ReBoardDAO{
	//쿼리문 수행객체를 얻기위한 SqlSessionFactory를 보유한 매니저 선언
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	
	//등록 후, pk를 반환하는 메서드
	public int insert(ReBoard reboard) {
		SqlSession sqlSession = configManager.getSession();//세션얻기
		
		System.out.println("넣기 전 reboard_id는 "+reboard.getReboard_id()); //0
		
		int result=sqlSession.insert("ReBoard.insert", reboard);
		sqlSession.commit();
		
		System.out.println("넣은 후 reboard_id는 "+reboard.getReboard_id());//현재 세션에서의 최신 pk
		
		configManager.closeSession(sqlSession);//세션닫기
		return result;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReBoard select(int reboard_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ReBoard reboard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int reboard_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStep(ReBoard reboard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reply(ReBoard reboard) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

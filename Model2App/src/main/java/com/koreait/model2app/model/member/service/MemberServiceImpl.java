package com.koreait.model2app.model.member.service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.util.FileManager;
import com.koreait.model2app.util.pool.PoolManager;

//서비스 인터페이스를 구현한 구현 클래스 
//왜 서비스에 인터페이스까지 둬야 하는지 의문이 생기겠지만, 담주까지 참자...
//이유 어플리케이션의 의존성을 약화시키기 위함..(DI를 배워야 이해가능함..)
public class MemberServiceImpl implements MemberService{
	
	private PoolManager pool=PoolManager.getInstance(); //DAO들사이의 Connection을 
																				//공유하기 위해...
	//부장님이 일시킬 모델 객체들...
	FileManager fileManager; //파일업로드
	MemberDAO memberDAO;//회원정보
	LicenseDAO licenseDAO;//자격증정보
	
	public MemberServiceImpl() {
		memberDAO = new JdbcMemberDAO();
		licenseDAO = new JdbcLicenseDAO();
	}
	
	public int regist(Member member, HttpServletRequest request) {
		
		fileManager.saveFile(request);//파일업로드!!  1/3
		
		Connection con=pool.getConnection(); //DAO들에게 나누어줄 커넥션 얻기!!
		((JdbcMemberDAO)memberDAO).setCon(con);//Connection 객체 주입
		((JdbcLicenseDAO)licenseDAO).setCon(con);//Connection객체 주입 
		
		int member_id=memberDAO.insert(member);// 2/3

		List<License> list=member.getList();
		
		for(License obj : list) {
			obj.setMember_id(member_id);//회원등록시 발생한 시퀀스 값을 대입해야 함
			licenseDAO.insert(obj); // 3/3
		}
		
		pool.release(con);//반납
		
		return 0;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int member_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

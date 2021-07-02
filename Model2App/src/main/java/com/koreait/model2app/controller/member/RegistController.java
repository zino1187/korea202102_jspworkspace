package com.koreait.model2app.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.util.FileManager;

//회원의 등록 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	//3단계: 알맞는 로직객체에 일 시킨다 , 4단계: 결과가 있을때는 저장 (X)
	MemberDAO memberDAO;
	LicenseDAO licenseDAO;
	
	public RegistController() {
		memberDAO = new JdbcMemberDAO();
		licenseDAO = new JdbcLicenseDAO();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//파일업로드
		Member member = FileManager.saveFile(request); //파일업로드 처리
		
		//DB에 insert
		int member_id=memberDAO.insert(member);
		
		//자격증 insert (자격증 갯수만큼 반복문으로 insert 실행!!)
		System.out.println("당신이 취득한 자격증은 "+member.getList().size());
		List<License> list=member.getList();
		
		for(License obj : list) {
			obj.setMember_id(member_id);//회원등록시 발생한 시퀀스 값을 대입해야 함
			licenseDAO.insert(obj);
		}
		
	}
	public String getViewName() {
		return "/result/member/regist";
	}
	public boolean isForward() {
		return false;//재접속을 시킬것임!!
	}	
}

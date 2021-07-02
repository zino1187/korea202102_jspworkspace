package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;
import com.koreait.model2app.util.FileManager;

//회원의 등록 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	//3단계: 알맞는 로직객체에 일 시킨다 , 4단계: 결과가 있을때는 저장 (X)
	MemberService memberService;
	FileManager fileManager;
	
	public RegistController() {
		memberService = new MemberServiceImpl();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Member member=fileManager.saveFile(request);//파일 업로드 
		
		memberService.regist(member, request);		
	}
	
	public String getViewName() {
		return "/result/member/regist";
	}
	public boolean isForward() {
		return false;//재접속을 시킬것임!!
	}	
}

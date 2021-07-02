package com.koreait.model2app.controller.member;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;

//회원의 등록 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	//3단계: 알맞는 로직객체에 일 시킨다 , 4단계: 결과가 있을때는 저장 (X)
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//파라미터 받기 
		String name;
		String phone;
		String addr;
		String photo; //최종적으로 개발자가 바꾼 이미지명.. ex)  4567844897.jpg
		
		//파라미터가 배열인 경우의 처리 
		Enumeration en=request.getParameterNames(); //배열 파라미터의 갯수를 파악하기 위한 메서드
		while(en.hasMoreElements()) {
			System.out.println("aaaa");
		}
	}
	

	@Override
	public String getViewName() {
		return null;
	}

	@Override
	public boolean isForward() {
		return false;
	}	
}

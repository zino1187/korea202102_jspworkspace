package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;

//회원상세 정보 요청을 처리할 하위 컨트롤러 
public class DetailController implements Controller{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	}

	public String getViewName() {
		return null;
	}
	public boolean isForward() {
		return false;
	}
	
}	

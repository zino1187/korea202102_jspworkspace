package com.koreait.model2app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹클라이언트의 모든~~~요청을 받는 유일한 진입점 서블릿( 요청을 분석하여 어떤 하위컨트롤러가 요청을 전담할
//를 결정짓고, 해당 하위컨트롤러가 업무를 마친후엔, 결과를 다시 클라이언트에게 전달 즉 응답을 처리한다) 
//1.요청을 받는다 ,2.요청을 분석, 5단계 처리 
public class DispatcherServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//하위컨트롤러에게  request, response 객체를 전달하기 전에 공통적인 기능이 있다면, 형님 컨트롤러에서
		//처리해줘야 코드 중복을 피할 수 있다!! ( 안해도 되지만 코드가 속상함..) 
		request.setCharacterEncoding("utf-8");
		
		
		//요청을 분석(uri분석한다)
		String uri = request.getRequestURI();
		System.out.println("요청받은 uri는 "+uri);
	}
}









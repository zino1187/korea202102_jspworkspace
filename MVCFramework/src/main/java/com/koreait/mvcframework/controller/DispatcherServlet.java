package com.koreait.mvcframework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이 서블릿은 우리 웹어플리케이션의 모든~~~~요청을 일단 받는 진입점 컨트롤러임
public class DispatcherServlet extends HttpServlet{
	/* 모든 컨트롤러의 업무처리 순서 
	 * 1.요청을 받는다
	 * 2.요청을 분석한다(어떤 하위 컨트롤러에게 업무를 전달할지를 알아야 하므로...)
	 * 3.알맞는 로직 객체에 일 시킨다(하위 컨트롤러가...)
	 * 4.결과가 있다면 결과를 저장한다
	 * 5.결과를 보여준다
	 * */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1단계: 요청을 받는다
		System.out.println("요청을 받았습니다");
	}
	
}

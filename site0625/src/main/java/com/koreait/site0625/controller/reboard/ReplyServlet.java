package com.koreait.site0625.controller.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//답변 등록 요청을 처리하는 서블릿
public class ReplyServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//답변에 필요한 파라미터 받기 
		request.setCharacterEncoding("utf-8");
		int team=Integer.parseInt(request.getParameter("team"));
		int step=Integer.parseInt(request.getParameter("step"));
		int depth=Integer.parseInt(request.getParameter("depth"));
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		//답변 등록을 위한 메서드 호출 (자리확보 + 답변등록)
		
		
	}
}

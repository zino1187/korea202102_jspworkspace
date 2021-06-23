package com.koreait.site0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.member.dao.MemberDAO;
import com.koreait.site0622.model.member.dao.MybatisMemberDAO;
import com.koreait.site0622.util.message.MessageObject;

//로그인 요청을 처리하는 서블릿
public class LoginServlet extends HttpServlet{
	MemberDAO memberDAO;
	MessageObject messageObject;
	
	public void init() throws ServletException {
		memberDAO = new MybatisMemberDAO();
		messageObject = new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 
		String user_id=request.getParameter("user_id");
		String password=request.getParameter("password");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(user_id+"<br>");
		out.print(password+"<br>");
	
		//파라미터값을 이용(VO에 담아)하여, 회원조회
		Member member = new Member();
		member.setUser_id(user_id);
		member.setPassword(password);
		
		Member obj=memberDAO.select(member);
		
		if(obj==null) {
			out.print(messageObject.getMsgBack("로그인 정보가 올바르지 않습니다"));
		}else {
			out.print(messageObject.getMsgURL("로그인 성공", "/admin/main.jsp"));
		}
		
	}
}












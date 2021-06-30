package com.koreait.mvcframework.controller.blood;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.model.blood.BloodService;

//혈액형 요청을 처리하는 컨트롤러 클래스
public class BloodController extends HttpServlet{
	BloodService service;
	
	@Override
	public void init() throws ServletException {
		service = new BloodService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String blood = request.getParameter("blood");

		String msg= service.getAdvice(blood);
		
		request.setAttribute("msg", msg); //request 객체는 사실 Map임
		
		RequestDispatcher dis=request.getRequestDispatcher("/blood/result.jsp");
		dis.forward(request, response); //쌍방울을 가지고,  result.jsp로 전달된다!!
	}
	 
}

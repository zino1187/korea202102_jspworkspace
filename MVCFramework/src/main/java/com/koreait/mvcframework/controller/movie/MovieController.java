package com.koreait.mvcframework.controller.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.model.movie.MovieService;

//영화에 대한 요청을 처리하는 컨트롤러 
public class MovieController{
	MovieService service;

	public MovieController() {
		service = new MovieService();
	}
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movie = request.getParameter("movie");//파라미터 받기!!
		
		//3단계: 알맞는 로직 객체에 일 시킨다!!
		String msg=service.getAdvice(movie);
		
		//4단계: 보여질 결과가 있다면 결과를 request 에 저장!!
		request.setAttribute("msg", msg);
	
	}
	
}














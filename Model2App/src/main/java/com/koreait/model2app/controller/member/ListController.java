package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;

public class ListController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	}
	public String getViewName() {
		return "/result/member/list";
	}
	public boolean isForward() {
		return false;
	}
}

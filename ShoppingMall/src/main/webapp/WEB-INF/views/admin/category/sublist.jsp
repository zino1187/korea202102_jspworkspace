<%@page import="com.koreait.shoppingmall.domain.SubCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//이 jsp는 디자인을 응답정보로 보내기 위함이 아니라, json 데이터를 응답정보로 보내기 위한 페이지임.
	List<SubCategory> subList=(List)request.getAttribute("sublist");

	//List --> Json 데이터로 변환해서 클라이언트에게 응답정보로 전송 
%>
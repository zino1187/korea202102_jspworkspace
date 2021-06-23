<%@page import="com.koreait.site0622.model.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//서블릿으로 변경된후, service메서드의 영역 
	
	//파라미터들을 넘겨받아 db에 insert!!
	request.setCharacterEncoding("utf-8"); //request내장객체는 HttpServletRequest가 자료형임
	
%>
<jsp:useBean id="member" class="com.koreait.site0622.model.domain.Member"/>
<jsp:setProperty property="user_id" 	name="member"/>
<jsp:setProperty property="password" 	name="member"/>
<jsp:setProperty property="name" 		name="member"/>

<%="jsp빈즈 태그에 의해 채워진 데이터는 "+member.getUser_id()%>
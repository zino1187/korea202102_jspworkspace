<%@page import="com.koreait.site0622.util.message.MessageObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	MessageObject msg=new MessageObject(); 
%>
<%
//접근을 원천봉쇄
//세션에 vo가 존재하지 않는다면, 이 유저는 인증받은 적이 없다는 것이다!!
//따라서 현제 페이지에 대한 접근을 막자!!
if(session.getAttribute("member")==null){
	//욕하기!!
	out.print(msg.getMsgBack("로그인이 필요한 서비스입니다"));
}else{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
댓글을 관리하는 모드
</body>
</html>
<%}%>
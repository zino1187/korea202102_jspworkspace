<%@ page contentType="text/html;charset=UTF-8"%>
<%
	RuntimeException e=(RuntimeException)request.getAttribute("e"); //에러객체
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgColor="yellow">
이용에 불편을 드려 죄송합니다. <br>
<%=e.getMessage() %>	
</body>
</html>
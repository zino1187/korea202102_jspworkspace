<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
선택하신 혈액형에 대한 판단 결과 <br>
<%=msg %>
</body>
</html>
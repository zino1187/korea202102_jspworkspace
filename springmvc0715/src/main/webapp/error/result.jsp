<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<img src="https://cdn4.iconfinder.com/data/icons/refresh_cl/128/Symbols/Warning.png">
	<%
		RuntimeException e=(RuntimeException)request.getAttribute("e");
		String msg=e.getMessage();
		out.print(msg);
	%>
	<a href="/board/list">메인으로</a>
</body>
</html>
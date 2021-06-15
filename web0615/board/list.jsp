<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%!
	//선언부  - 멤버영역에 해당 
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
%>
<%
	//스크립틀릿  - 메서드 영역에 해당 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","webmaster","1234");
	if(con ==null){
		out.print("접속실패<br>");
	}else{
		out.print("접속성공<br>");
	}
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
</body>
</html>
<%
	con.close();
%>

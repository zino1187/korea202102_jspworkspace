<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		앞으로는 자바 코드안에 DBMS 에 대한 접속 정보가 없기 때문에 
		현재 사용중인 웹서버가 제공하는 JNDI( 이름으로 자원을 찾을 수 있는 기법)를 이용하여 커넥션을 취득한다!!
	</pre> 
	<%
		InitialContext ctx=new InitialContext(); // jndi로 검색을 실시하는 객체 
		
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jndi/oracle"); //검색어를 입력
		out.print(ds+"<br>");
		
		//이 시점 부터 커넥션풀링 객체를 보유한 것이다!!
		
		Connection con = ds.getConnection(); //풀로부터 커넥션 한개 대여!!
		PreparedStatement pstmt=con.prepareStatement("select count(*) as cnt from board");
		ResultSet rs=pstmt.executeQuery();
		rs.next(); //커서 한칸 이동 
		
		int total = rs.getInt("cnt");
		out.print("총 레코드 수는 "+total);
		
		con.close();
	
	%>	
</body>
</html>
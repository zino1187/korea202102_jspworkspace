<%@page import="com.koreait.site0622.model.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.site0622.model.office.dao.EmpDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	EmpDAO empDAO = new EmpDAO();
	List<Emp> empList = empDAO.selectAll(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="1px">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
		</tr>
		<%for(Emp emp : empList){%>
		<tr>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
			<td><%= %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>








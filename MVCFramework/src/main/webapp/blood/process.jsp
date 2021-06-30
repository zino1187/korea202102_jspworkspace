<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//클라이언트가 전송한 파라미터를 받아 결과 보여주기 
	request.setCharacterEncoding("utf-8");
	String blood = request.getParameter("blood");
	String msg=null;
	//넘겨받은 혈액형에 대한 판단 결과 도출
	if(blood.equals("A형")){
		msg="소심하고 꼼꼼하고 책임감 강함";
	}else if(blood.equals("B형")){
		msg="고집쎄고 털털하다";
	}else if(blood.equals("O형")){
		msg="잘 어울리고 오지랖이다";
	}else if(blood.equals("AB형")){
		msg="선택을 왔다갔다(여자의 경우)";		
	}
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
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String myfile=request.getParameter("myfile");
	
	out.print(myfile.length());
	
	if(myfile!=null){
		out.print("파일 교체를 원하는 군요<br>");
		//사용자가 새로운 파일의 업로드를 희망할 경우
	}else{
		out.print("기존 파을 유지하는 군요<br>");
		//DB만 수정할 경우
	}

%>

<%@page import="com.koreait.site0622.model.domain.News"%>
<%@page import="com.koreait.site0622.model.news.dao.MybatisNewsDAO"%>
<%@page import="com.koreait.site0622.model.news.dao.NewsDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!NewsDAO newsDAO = new MybatisNewsDAO(); %>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	News news = newsDAO.select(news_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("content");
	
	//버튼에 이벤트 연결하기 
	$("input[type='button']").click(function(){
		regist();	
	});
});

//수정요청
function edit(){
	$("#form1").attr({
		"action":"",
		"method":"post"
	});	
	$("#form1").submit();
}

//댓글 등록(새로고침 없이!! 즉 비동기로 처리)
function registComments(){
	$.ajax({
		url:"/comments/regist",
		type:"post", 
		data:{
			msg:$("input[name='msg']").val(),
			cwriter:$("input[name='cwriter']").val()
		},
		success:function(result, status, xhr){
			alert(result);
		}
	});
}

</script>
</head>
<body>

<h3>상세보기</h3>

<div class="container">
  <form id="form1">
    <input type="text" 	name="title" 			value="<%=news.getTitle()%>">
    <input type="text" 	name="writer" 		value="<%=news.getWriter()%>">
    <textarea 				name="content" 	style="height:200px"><%=news.getContent()%></textarea>
    <input type="button" value="Submit">
  </form>
</div>
<div>
	<form id="form2">
		<input type="text" name="msg" 		placeholder="댓글 메시지..." style="width:60%">
		<input type="text" name="cwriter" 	placeholder="작성자..." style="width:20%">
		<input type="button" value="댓글등록"  style="width:10%" onClick="registComments()">
	</form>
</div>
<div>
	<input type="text" value="댓글 메시지..." style="width:60%" readonly>
	<input type="text" value="작성자..." style="width:20%" readonly>
	<input type="text" value="등록일" style="width:10%" readonly>
</div>
</body>
</html>
    
    
    
    
    
    
    
    
    
    
<%@ page contentType="text/html;charset=utf-8"%>
<%
	int totalRecord=26;//총 게시물 수
	int pageSize=10;//총 게시물을 몇건씩 나누어서 보여줄지를 결정짓는 변수, 즉 페이지당 보여줄 레코드 수
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize); //총 페이지 수(나머지 숨겨진 데이터를 보기위한 페이지 분할된 총 수)
	
%>
<%=totalPage+"<br>" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
  position:relative;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){

});
</script>
</head>
<body>

<h2>게시판 목록</h2>

<table>
	<tr>
		<th>No</th>
		<th>이미지</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<%for(int i=1;i<=pageSize;i++){ %>
	<tr>
		<td>Jill</td>
		<td></td>
		<td>
			
		</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<%}%>
	<tr>
		<td colspan="6" style="text-align:center">
			<%for(){%>
			[1][2][3]
			<%}%>
		</td>
	</tr>
</table>
</body>
</html>

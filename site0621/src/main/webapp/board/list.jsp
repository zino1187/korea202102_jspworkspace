<%@ page contentType="text/html;charset=utf-8"%>
<%
	int totalRecord=126;//총 게시물 수
	int pageSize=10;//총 게시물을 몇건씩 나누어서 보여줄지를 결정짓는 변수, 즉 페이지당 보여줄 레코드 수
	
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize); //총 페이지 수(나머지 숨겨진 데이터를 보기위한 페이지 분할된 총 수)
	int blockSize=10;
	
	int currentPage=1;//현재 페이지
	//단, 사용자가 아래의 페이지 링크를 눌러 currentPage파라미터 값을 넘길경우엔 그 넘어온 값을 우선해야 한다!!
	if(request.getParameter("currentPage")!=null){
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	}
%>
<%="당신이 보고 잇는 페이지는 "+currentPage+"<br>" %>
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

/*나만의 페이지 번호 스타일을 클래스로 정의 */
.pageNum{
	font-weight:bold;
	font-size:20px;
	color:red;
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
			<a href="#">◀</a>
			<%for(int i=1;i<=blockSize;i++){%>
				<a href="/board/list.jsp?currentPage=<%=i%>"   <%if(currentPage==i){%>class="pageNum"<%}%>   >[<%=i%>]</a>
			<%}%>
			<a href="#">▶</a>
		</td>
	</tr>
</table>
</body>
</html>

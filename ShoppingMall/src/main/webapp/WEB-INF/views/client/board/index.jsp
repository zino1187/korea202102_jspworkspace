<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrapper{
	width:100%;
	height:600px;
	overflow:hidden;
}
.regist-area{
	width:20%;
	height:100%;
	background:pink;
	float:left;
}
#list-area{
	width:60%;
	height:100%;
	background:#CCCEEE;
	float:left;
}
.detail-area{
	width:20%;
	height:100%;
	background:#EE66DD;
	float:left;
}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="regist-area">입력폼</div>
		<div id="list-area">리스트</div>
		<div class="detail-area">상세영역</div>
	</div>
</body>
</html>
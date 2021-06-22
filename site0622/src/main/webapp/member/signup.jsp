<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script type="text/javascript">
$(function(){
	//버튼들에 이벤트 연결하기 
	$("#bt_check").click(function(){
		checkId();	
	});
	
	$("#bt_regist").click(function(){
		regist();
	});
});

//회원가입 전에 아이디 중복여부 체크
function checkId(){
	$("form").attr({
		"action":"/member/idcheck",
		"method":"post"
	});
	$("form").submit(); //전송 
}

function regist(){
	
}

</script>
</head>
<body>

<h3>회원가입</h3>

<div class="container">
  <form>
    <input type="text" name="user_id" 			placeholder="Your ID.." style="width:70%">
    <input type="button" value="ID중복확인" id="bt_check">
    
    <input type="text" name="password" 		placeholder="Your Password..">
    <input type="text" name="name" 			placeholder="Your Name..">
    <input type="button" value="회원등록" id="bt_regist">
  </form>
</div>

</body>
</html>

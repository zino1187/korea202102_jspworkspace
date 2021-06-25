<%@page import="com.koreait.site0625.model.domain.ReBoard"%>
<%@page import="com.koreait.site0625.model.reboard.dao.MybatisReBoardDAO"%>
<%@page import="com.koreait.site0625.model.reboard.dao.ReBoardDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!ReBoardDAO reBoardDAO=new MybatisReBoardDAO(); %>
<%
	int reboard_id=Integer.parseInt(request.getParameter("reboard_id"));
	ReBoard reboard=reBoardDAO.select(reboard_id);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
#box{border:1px solid #CCCCCC}
#writer,#title,#content{font-size:9pt;font-weight:bold;color:#7F7F7F;돋움}
input{
	font-size:9pt;
	border-left:1px solid #C3C3C3;
	border-top:1px solid #C3C3C3;
	border-right:1px solid #C3C3C3;
	border-bottom:1px solid #C3C3C3;
	color:#7F7F7F;돋움
}
#title input{width:250px;}
#content textarea{
width:503px;
border:0;
height:153;
background:url("/reboard/images/write_bg.gif");
border:#C3C3C3 1px solid 
}
#copyright{font-size:9pt;}
a{text-decoration:none}
img{border:0px}
</style>
<%@ include file="/reboard/inc/lib.jsp" %>

<script type="text/javascript">
//답변 폼 요청하기
function replyForm(){
	$("form").attr({
		"action":"/reboard/reply.jsp",
		"method":"post"
	});
	$("form").submit();
}
</script>
</head>
<body>
<form>
<input type="hidden" name="team" value="<%=reboard.getTeam()%>"> 
<input type="hidden" name="step" value="<%=reboard.getStep()%>"> 
<input type="hidden" name="depth" value="<%=reboard.getDepth()%>"> 

<table id="box" align="center" width="603" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="/reboard/images/ceil.gif" width="603" height="25"></td>
  </tr>
  <tr>
    <td height="2" bgcolor="#6395FA"><img src="/reboard/images/line_01.gif"></td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
	<tr>	
		<td id="list"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="100">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr id="title">
            <td height="25" align="center">제목</td>
            <td><input type="text" name="textfield2" value="<%=reboard.getTitle()%>"></td>
          </tr>
          <tr id="writer">
            <td height="25" align="center">작성자</td>
            <td><input type="text" name="textfield" value="<%=reboard.getWriter()%>"></td>
          </tr>
          <tr id="content">
            <td align="center">내용</td>
            <td><textarea name="content" style=""><%=reboard.getContent()%></textarea></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
	</tr>
  <tr>
    <td height="30" align="right" style="padding-right:2px;">
    <img src="/reboard/images/reply_btn.gif" width="61" height="20" onClick="replyForm()">
	<img src="/reboard/images/write_btin.gif" width="61" height="20">
	<img src="/reboard/images/delete_btn.gif" width="61" height="20"> 
	<a href="list.html"><img src="/reboard/images/list_btn.gif" width="61" height="20" border="0"></a> </td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="20" align="center" id="copyright">Copyright zino All Rights Reserved </td>
  </tr>
</table>
</form>
</body>
</html>

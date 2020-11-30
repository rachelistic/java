<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>borderInput</title>
</head>
<body>
<div id = "upload" align = "center">
<br>
<br>
<h1> &ensp;글 쓰 기</h1>
<form id="frm" name="frm" action="/Member/BorderInput.do" method="get">
<table border=1>
<tr><th>작성자</th><td><input name="writer" id = "writer" type="text" size=100></td></tr>
<tr><th>작성일</th><td><input name="wdate" id = "wdate" type="date" size=100></td></tr>
<tr><th>제목</th><td><input name="title" id = "title" type="text" size=100></td></tr>
<tr><th>내용</th><td><textarea name="content" id ="content" rows=4 cols=103></textarea></td></tr>
</table><br>
&ensp;

<input type = "submit" id="save" name="save" value="등록하기 ">
<input type ="button" onClick="location.href='/Member/BorderList.do'" id="list" name="list" value ="취소하기">
</form>

</div>
</body>
</html>
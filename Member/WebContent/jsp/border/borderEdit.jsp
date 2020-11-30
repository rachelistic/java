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
<h1> &ensp;글 수 정</h1>
<form id="frm" name="frm" action="/Member/BorderEdit.do" method="get">
<table border=1>
<tr>
	<th>작성자</th>
	<td>${vo.borderWriter}</td>
</tr>
<tr>
	<th>작성일</th>
	<td><input name="wdate" id = "wdate" type="date" size=100 value="${vo.borderDate}"></td>
</tr>
<tr>
	<th>제목</th>
	<td>${vo.borderTitle}</td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea name="content" id ="content" rows=4 cols=100>${vo.borderContent}</textarea></td>
</tr>
</table><br>
&ensp;
<input type="hidden" id = "id" name="id" value="${vo.borderId}">
<input type = "submit" value="수정하기 ">
<input type = "button" onClick="location.href='/Member/BorderRead.do?id=${vo.borderId}'" id="save" name="cancel" value="취소">
<input type ="button" onClick="location.href='/Member/BorderList.do'" id="list" name="list" value ="목록보기">
</form>

</div>
</body>
</html>
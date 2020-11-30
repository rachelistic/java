<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<style>
td {width: 200px; align:"center";}
textarea { width:99.5%;}
</style>
<meta charset="UTF-8">
<title>BordeRead 글보기</title>



</head>
<body>

<div align ="center">
<br>
<br>
	<div><h1>글 상세보기</h1></div>
	<div>
	<table border=1>
	<tr>
		<th>작성자</th>
		<td>${vo.borderWriter}</td>
		<th>작성일자</th>
		<td>${vo.borderDate}</td>
		<th>조회수</th>
		<td>${vo.borderHit}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td width="700" colspan ="5">${vo.borderTitle}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td width="700" colspan ="5">
			<textarea id="content" name="content" rows="7">${vo.borderContent}</textarea>
		</td>
	</tr>
	
	</table>
	<br/>
	</div>
		<div>
		<form id="frmm" name="frmm" method="post" action="">
		<input type="hidden" id="id" name="id" value="${vo.borderId}">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 아까 히든 말들어준데어데? -->
		<button type ="submit" onClick='formSubmit("1")'>글수정</button>&nbsp;&nbsp;&nbsp;
		<button type ="submit" onClick='formSubmit("2")'>글삭제</button>&nbsp;&nbsp;&nbsp;
		<button type ="button" onClick="location.href='/Member/BorderList.do'">목록보기</button>

		</form>
		</div>	
	

</div>

</body>

<script type="text/javascript">

function formSubmit(n){
	if(n=="1"){
		frmm.action="/Member/BorderSearch.do";
		
	}else if(n=="2"){
		frmm.action="/Member/BorderDel.do";
		}
 }
 
</script>
</html>
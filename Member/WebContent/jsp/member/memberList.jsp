<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<style>
tr:hover {
	background-color: #E0E5E9;
}

th {
	background-color: #E0E5E9;
}
</style>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Member List</title>

</head>
<body>
	<div style="padding: 20px;">

		<h1>목 록</h1>


<!-- 		<div id="searchForm" align="right" style="padding-right: 0%;">

			<form id="option" action="/Member/SearchBar.do">
				<select name="opt">
					<option value="0">제목</option>
					<option value="1">글쓴이</option>
					<option value="2">내용</option>
				</select> <input type="text" size="20" name="condition">&nbsp; <input
					type="submit" value="검색" /> <input type="button"
					onClick="location.href='jsp/border/borderInput.jsp'" value="글쓰기"
					id="write" name="write">
			</form>
		</div>
 -->



		<br>
		<table border=1 style="width: 100%">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>패스워드</th>
				<th>권한</th>
				<th>성별</th>
				<th>포인트</th>
				<th>생년월일</th>
				<th>이메일</th>
			</tr>
			<!-- 수정이 필요한 부분 forEach 구문 사용해서 반복 처리 필요 -->
			<c:forEach var="vo" items="${list }">
				<tr
					onClick="location.href='/Member/MemberRead.do?id=${vo.memberId}'">
					<td width="200px">${vo.memberId }</td>
					<td width="200px">${vo.memberName }</td>
					<td width="200px">${vo.password }</td>
					<td width="200px">${vo.memberAuth }</td>
					<td width="200px">${vo.gender }</td>
					<td width="200px">${vo.memberPoint }</td>
					<td width="200px">${vo.birthDay }</td>
					<td width="200px">${vo.email }</td>
			</c:forEach>
		</table>
		<br>



	</div>
	
</body>
</html>
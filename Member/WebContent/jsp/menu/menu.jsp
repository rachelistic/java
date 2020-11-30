<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/Member/css/menu.css" >
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>

</style>
<meta charset="UTF-8">
<title>jsp/menu/menu.jsp</title>
</head>
<body>

<div align="center">
<h1>행복한 사람들의 공간</h1></div>
	<ul id="nav">
		<c:if test="${id eq null}">
		<li><a href="/Member/jsp/member/loginForm.jsp">로그인</a></li>
		
		</c:if>
		<li><a href="#">메인메뉴</a>
			<ul>
				<li><a href="#">1-1</a></li>
				<li><a href="#">1-2</a></li>
			</ul>
		</li>
		<li><a href="/Member/BorderList.do">자유게시판</a></li>
		
		
		<c:if test="${auth eq 'admin'}">
		<li><a href="#">에드민</a>
				<ul>
					<li><a href="/Member/MemberList.do">회원관리</a></li>
					<li><a href="#">4-2</a></li>
				</ul>
		</li>
		</c:if>
		<c:if test="${name ne null}"><!-- 권한제어 !  -->
		<li><a href="/Member/Logout.do">로그아웃</a></li>
		</c:if>
	</ul>
	
</body>

</html>
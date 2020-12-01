<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login result</title>
</head>
<body>
	<div align="center">
		<c:if test = "${auth ne null}">
			<h1>아이디는 ${vo.memberId} 님 환영합니다.</h1>
			<h1>${vo.memberAuth}, 권한으로 로그인함</h1>
			<h1>${vo.memberName}, 님 환영합니다.</h1>
			
		
			<div></div>
		</c:if>
		<!-- c:if는 엘즈가 없음  -->
		<c:if test = "${auth eq null}">
			<h1>${vo.memberId}가 존재하지 않거나 패스워드가 일치하지 않습니다.</h1>
			<div></div>
		</c:if>

	</div>

</body>
</html>

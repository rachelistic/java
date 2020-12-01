<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterResult</title>
</head>
<body>
	<div align="center">
		<h2>성공적으로 가입되었습니다.</h2>
		<br>
			<h2>&ensp;&ensp;  로그인하기</h2>
			<div>
				<form id="frm" name="frm" action="/Member/Login.do" method="post">
					<table>
						<tr>
							<th>아이디</th>
							<td><input type="text" id="mid" name="mid" size="20"></td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td><input type="text" id="mpw" name="mpw" size="20"></td>
						</tr>
					</table>
					<br>
					<div>
					&ensp;&ensp;&ensp;&ensp; <input type="submit" value="제출하기">
					</div>
				</form>
				<br>
				계정이 없나요? <a href="registerForm.jsp">회원가입하기</a>
			</div>
		</div>

</body>
</html>
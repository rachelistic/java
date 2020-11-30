<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../menu/menu.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>로 그 인</h1>
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
					<input type="submit" value="제출하기">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
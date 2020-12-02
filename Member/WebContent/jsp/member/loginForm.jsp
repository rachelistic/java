<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div align="center">
		<div>
			<h2>로 그 인</h2>
			<div>
				<form id="frm" name="frm" action="/Member/Login.do" method="post">
					<table>
						<tr>
							<th>아 이 디 &ensp;&ensp; </th>
							<td><input type="text" id="mid" name="mid" size="20" required></td>
						</tr>

						<tr>
							<th>비밀번호  &ensp;&ensp;</th>
							<td><input type="text" id="mpw" name="mpw" size="20" required></td>
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
	</div>

</body>
</html>
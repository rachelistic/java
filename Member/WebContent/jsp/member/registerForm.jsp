<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입하기</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>가 입 하 기</h1>
			<div id="userInfo">
				<form id="frm" name="frm" action="/Member/MemberInput.do" method="get">
					<table>
						<tr>
							<th>아이디</th>
							<td><img src="">
								<input type="text" id="rid" name="rid" size="10" onkeydown="inputIdChk()" required> 
								<input type="button" value="중복확인" onClick="openIdChk(1)" size="5"> 
								<input type="hidden" name="idDuplication" value="idUncheck"></td>
						</tr>
						<tr>
							<th>이 름</th>
							<td><input type="text" id="rname" name="rname" size="20">
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="text" id="rpw1" name="rpw1" size="20"
								required></td>
						</tr>
						<tr>
							<th>비번확인</th>
							<td><input type="text" id="rpw2" name="rpw2" size="20"
								value="다시 입력" required></td>
						</tr>
						<tr>
							<!-- <th>권 한</th> -->
							<td><input type="hidden" id="rauth" value="user"
								name="rauth" size="20"></td>
						</tr>
						<tr>
							<th>성 별</th>
							<td><input type="radio" id="rgender" name="rgender"
								size="20" value="male">남성 <input type="radio"
								id="rgender" name="rgender" size="20" value="female">여성
							</td>
						</tr>
						<tr>
							<!-- <th>포인트</th> -->
							<td><input type="hidden" id="rpoint" value="0" name="rpoint"
								size="20"></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td><input type="date" id="rbday" name="rbday" size="20"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" id="remail" name="remail" size="20"
								value="@gmail.com"></td>
						</tr>


					</table>
					<br>
					<div>
						
						<input type="button" value="등록하기" onClick="checkValue()" >
						<input type="button"
							onClick="location.href='/Member/jsp/member/loginForm.jsp'"
							value="취소하기">
					</div>
				</form>

			</div>
		</div>
	</div>

</body>



<script type="text/javascript">
	function checkValue() {
		/* var form = document.userInfo; */
		if (document.frm.idDuplication.value !="idCheck") {
			alert("아이디 중복 체크를 해주세요");
			return false;
		}else if(document.frm.rpw1.value != document.frm.rpw2.value) {
			alert("재입력된 비밀번호가 일치하기 않습니다.");
			return false;
			
		}else {
				document.frm.submit();
				alert("등록되었습니다.");
			}	
	}


	function openIdChk(n) {
		if (n == 1) {
			window
					.open("idCheck.jsp", "idcheck",
							"width=600, height=300,top=300px,left=400px, scrollbars=no");

		}
		/* 이프엘스 자리 다른 버튼 얼럿  */
	}

	function inputIdChk() {
		document.frm.idDuplication.value = "idUncheck";
		
	}
</script>

</html>
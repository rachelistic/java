<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheckForm.jsp</title>
</head>
<body onload="pValue()">
	<div id="check" style="text-align: center">
		<h3>* 아이디 중복확인 *</h3>
		<form method="post" id="checkForm" name="checkForm" action="/Member/MemberIdCheck.do">
			아이디 : <input type="text" name="userid" id="userid" required>
			<input type="button" value="중복확인" onClick="idCheck()" >
		</form>
		<div id="msg"></div><br>
	<div style="display:inline-block">
	<input id="cancelBtn" type="button" value="취소" onClick="window.close()">
	<input id="useBtn" type="button" value="사용하기" onClick="sendCheckValue()"><br>
	</div>
	</div>
	
	
	
	<script type=text/javascript> 
	 function pValue(){document.getElementById("userid").value = opener.document.frm.rid.value;}
	
	 function idCheck(){
		 var id = document.getElementById("userid").value;
		 if(id == ""){
			 alert("아이디를 입력하지않았음")
			 return false;
			 
		 }else { 
			 document.checkForm.submit();
		 }		 
	 }	
	 
	 function sendCheckValue(){
		 opener.document.frm.idDuplication.value ="idCheck";
		 opener.document.frm.rid.value = document.getElementById("userid").value;
		 
		 if(opener!= null){
			 opener.chkForm = null;
			 self.close();
		 }
		 
		 
	 }
	
	
	</script>
</body>
</html>


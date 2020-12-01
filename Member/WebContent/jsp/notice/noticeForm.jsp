<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Form 공지사항 쓰기</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>공 지 사 항 등 록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="/Member/NoticeInsert.do" method="post"
				enctype="multipart/form-data">
				<table border=1 style="text-align:center">
					<tr>
						<td>제목</td>
						<td><input type="text" id="title" name="title" size=100%; style=""></td>						
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="10" cols="102%" id="content" name="content"></textarea></td>						
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" id="attachfile" name="attachfile"  ></td>						
					</tr>
				</table>
				<br>
				<div>
					<input type="submit" value="저장">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
					<input type="button" value="목록보기" onClick="location.href='/Member/NoticeList.do'">&nbsp;&nbsp;&nbsp;					
				</div>
			</form>
		</div>
	</div>
</body>
</html>
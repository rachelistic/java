<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login result</title>
<script type="text/javascript">
<!-- Ajax 호출 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){   
   $.ajax({
      url: '/Member/AjaxNoticeList.do',
      dataType: 'json',
      success:function(data){
         console.log(data);
         if(data != null){      
            console.log("aaa")
            var tb = $("<table border='1' />")
            var row = $("<tr />").append(
                  $("<th />").text("순번"),
                  $("<th />").text("제목"),
                  $("<th />").text("작성자"),
                  $("<th />").text("작성일자"),
                  $("<th />").text("조회수"),
                  $("<th />").text("첨부파일")
            );
            tb.append(row);
            
            for(j of data.data){
               let attech;
               if(j.noticeAttech==null){
                  attech = "N";
               }else{
                  attech = "Y";
               }
               row = $("<tr />").attr("onclick","location.href='/Member/NoticeRead?id="+j.noticeId+"'").append(
                  $("<td />").text(j.noticeId),
                  $("<td />").text(j.noticeTitle),
                  $("<td />").text(j.noticeWriter),
                  $("<td />").text(j.noticeDate),
                  $("<td />").text(j.noticeHit),
                  $("<td />").text(attech)
               );
               tb.append(row);
            }
            
         }
         $("#notice").append(tb);
      },
      error:function(){
         console.log("aaaa");
      }
   })
})

	
</script>
</head>
<body>
	<div align="center">
		<br>
		<c:if test="${auth ne null}">
			<h2>${vo.memberAuth}&ensp;</h2>
			<h1>${vo.memberName}님 환영합니다.</h1>

			<div>오늘은 어떤 글을 써볼까요?</div>
			<h2>오늘의 감정 기록</h2>
			<a href="#">바로가기</a>
			<h2>이달의 심리테스트</h2>
			<a href="#">바로가기</a>
		</c:if>
		<!-- c:if는 엘즈가 없음  -->
		<c:if test="${auth eq null}">
			<br>
			<h1>${vo.memberId}가존재하지 않거나</h1>
			<h1>패스워드가 일치하지 않습니다.</h1>
			<a href="jsp/member/loginForm.jsp">로그인 페이지로</a>
			<div></div>
		</c:if>

	</div>

</body>
</html>

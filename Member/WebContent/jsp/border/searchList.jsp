<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>


<style>
tr:hover {background-color:#E0E5E9;}
th {background-color:#E0E5E9;}
</style>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>borderList</title>

</head>
<body>

  <div class="container-fluid">
    <div class="row">
 
      
      
      
      <!-- 9단길이의 첫번째 열 -->
<div class="col-md-9 col-sm-6">
<div style =padding:20px;>

<h1>검색결과</h1> 
  
  
  <div id="searchForm" align="right" style="padding-right:0%;" >
        <form id="option" action="/Member/SearchBar.do">
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition">&nbsp;
            <input type="submit" value="검색"/>
            <input type="button" onClick="location.href='jsp/border/borderInput.jsp'" value ="글쓰기" id="write" name="write">
        </form>    
    </div>
    

<br>
<table border=1 style="width:100%">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</tr>
<!-- 수정이 필요한 부분 forEach 구문 사용해서 반복 처리 필요 -->
	<c:forEach var="vo" items="${searchList}"> 
<tr onClick="location.href='/Member/BorderRead.do?id=${vo.borderId}'">
	<td width="200px">${vo.borderId }</td>
	<td width="200px">${vo.borderTitle }</td>
	<td width="200px">${vo.borderWriter }</td>
	<td width="200px">${vo.borderDate }</td>
	<td width="200px">${vo.borderHit }</td>
	</c:forEach>
</table>
<br>


</div>
      </div>
      
     
      </div>
     </div>







</body>
</html>
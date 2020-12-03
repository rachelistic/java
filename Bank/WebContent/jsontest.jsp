<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsontest.jsp</title>
<script type="text/javascript">
//JSON 배열[index0,1,2],객체{객체}
	obj =['kim','park','choi'];
	console.log('두번째 사람의 이름 ' + obj[1]);
	emp = {name:'scott', age:20, addr:'대구'};
	console.log('나이 '+ emp.age ) //emp["age"] 도 사용가능
	emparr=[{name:'scott', age:20, addr:'대구'},
		{name:'king', age:30, addr:['대구','서울']}];
	console.log('두번째 사원의 두번째 주소' + emparr[1].addr[1]);
	//객체 -> 스트링  랭스로 확인
	JSON.stringify(obj);
	
	// 객체 <= 스트링 
	obj2 = JSON.parce(str);
</script>

</head>
<body>

</body>
</html>
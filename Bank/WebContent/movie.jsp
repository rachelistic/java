<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.row{width:100%; top:0; left:0; height:100%; margin:0; padding:10px;}
.col-6{width:50%}
.col-12 {width:100%}


</style>
<meta charset="UTF-8">
<title>movie.jsp</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script>
	$(function() {
		url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101";
		$.ajax(url, {
			//dataType:"json",
			success : function(response) {
				console.log(response);
				//response.boxOfficeResult.dailyBoxOfficeList[0].movieNm
				//$("#result").html(response);
				var list = response.boxOfficeResult.dailyBoxOfficeList;
/* 				for (i = 0; i < 10; i++) {
					var movies = response.boxOfficeResult.dailyBoxOfficeList[i].movieNm;
					$("#result").append($("<li />").html(movies)); }*/

				for(m of list){
					$("#result").append($("<p />").html(m.movieNm));
					$("#result").append($("<p />").addClass("mcd").html(m.movieCd));
					//$("#result").append($("<li />").html(m.movieNm));
				}
					
				

			}
		});
	
	//영화정보 조회
		$("#result").on("click", ".mcd", function(){ 
			//왜 닷? 영화코드를 클릭하면 클릭한 영화 상세정보, 액터들 출력
			var movieCd =$(this).html();
			var url="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json" +
					"?key=430156241533f1d058c603178cc3ca0e&movieCd=" + movieCd;
			
			$.ajax(url, {
				success : function(response){
					var actorname = response.movieInfoResult.movieInfo.actors;
					for(a of actorname){
						$("#actor").append($("<a />").html(a.peopleNm));
					}
					console.log(response);
					
					
				}
			});//아작스
		})
	
	});
	
	
</script>
</head>
<body>
	<div class="row" align="center">
		<div class="col-12">
			<h1>박스오피스 순위</h1>
		</div>

		<div class="col-6" align="left">
			<div id="result"></div>
		</div>
		<div class="col-6" align="left">
			<div id="actor"></div>
		</div>
	</div>
</body>
</html>
package co.rachel.bank;

import java.util.ArrayList;

import com.google.gson.Gson;

import co.rachel.common.MyRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MovieRequest {

	public static void main(String[] args) {
		
		String strUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20201203";
		String response = MyRequest.get(strUrl);
		//아래 함수 호출
		//string -> java 객체로 
		Gson gson = new Gson();
		MovieList list = gson.fromJson(response, MovieList.class);
		
		//for 문 돌려 영화 제목만 출력 
		
		ArrayList<Movie> mvlist = list.boxOfficeResult.dailyBoxOfficeList; //요롷게 불러온다 ! 선언. 
		//일반 for
		for(int i = 0; i <mvlist.size(); i++) {
			String mvname = mvlist.get(i).movieNm;
			System.out.println(mvname);
		}
		/* 확장for
		 
		 // for(Movie m : mvlist) { System.out.println(m.movieNm); }
		 //자바는 listType name : 리스트이름 
		 */
		//json_lib
		System.out.println("==========JSON LIB============");
		JSONArray arr = JSONArray.fromObject(response);
		for(int i=0;i<arr.size(); i++) {
			JSONObject temp = arr.getJSONObject(i);
			System.out.println(temp.getString("movieNm"));
		}
		
		
		/*
		 * JSONObject obj = JSONObject.fromObject(response); JSONArray arr=
		 * (JSONArray)obj.get(list); for(int j=0; j<arr.size();j++) { JSONObject temp =
		 * arr.getJSONObject(j); System.out.println(temp.getString("MovieNm")); }
		 */
	
	
	}

}

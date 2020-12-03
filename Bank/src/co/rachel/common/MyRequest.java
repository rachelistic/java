package co.rachel.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyRequest {

	
	public static String get(String strUrl){
		StringBuilder sb = new StringBuilder(); // 결과값
		// 문자를 연결하기 위해서 띄어쓰는 것까지 어팬드 이용해서 쓰라
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); // 서버 연결, url커넥션에 서버 연결값 담음

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) { // jdbc 디비 연결하듯 서버 연결
				BufferedReader br = new BufferedReader(

						// Stream을 처리해줘야 하는 귀찮음이 있음. BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "utf-8")); // 서버쪽에서 응답 들어오는게 겟인풋으로
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				/* System.out.println("" + sb.toString()); */
			} else {
				System.out.println(con.getResponseMessage());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return sb.toString();// 결과

	
	}
	
	
}


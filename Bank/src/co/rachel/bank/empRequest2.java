package co.rachel.bank;

import com.google.gson.Gson;

import co.rachel.common.MyRequest;
import net.sf.json.JSONObject;

public class empRequest2 {
		public static void main(String[] args) {
			
			String strUrl = "http://192.168.0.79/bank/empList2.jsp";
			String response = MyRequest.get(strUrl);	
			
			//gson
			Gson gson = new Gson();
			Emp emp = gson.fromJson(response,Emp.class);		
			System.out.println(emp.addr);
		
			//json_lib
			JSONObject obj = JSONObject.fromObject(response);
			System.out.println("==========JSON LIB============");
			System.out.println(obj.getString("name"));
			System.out.println(obj.getString("age"));
			System.out.println(obj.getString("addr"));
		
		}
	

		
}

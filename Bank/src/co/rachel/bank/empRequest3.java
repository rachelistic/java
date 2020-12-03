package co.rachel.bank;

import com.google.gson.Gson;

import co.rachel.common.MyRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class empRequest3 {

	public static void main(String[] args) {
		
		String strUrl = "http://192.168.0.79/bank/empList3.jsp";
		String response = MyRequest.get(strUrl);	
		
		//gson
		Gson gson = new Gson();
		Emp[] empList = gson.fromJson(response, Emp[].class);
		for(Emp emp : empList) {
			System.out.println(emp.name);
		}
		
		
		//json-lib
		System.out.println("====json lib========");
		JSONArray arr = JSONArray.fromObject(response);
		for(int i=0;i<arr.size(); i++) {
			JSONObject temp = arr.getJSONObject(i);
			System.out.println(temp.getString("name"));
		}
	/*	List<Emp> empList =Arrays.asList(emp);
	//	gson.fromJson(response, new TokenType<List<Emp>>() {}.getType());
		System.out.println(empList[1]);*/
	
	
	
	}

}

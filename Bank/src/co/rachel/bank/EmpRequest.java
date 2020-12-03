package co.rachel.bank;

import com.google.gson.Gson;

import co.rachel.common.MyRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmpRequest {

	public static void main(String[] args) {
		String strUrl = "http://192.168.0.79/bank/empList.jsp";
		String response = MyRequest.get(strUrl);
		Gson gson = new Gson();
		EmpList empList = gson.fromJson(response, EmpList.class);

		for (int i = 0; i < empList.getEmpList().size(); i++) {
			Emp temp = empList.getEmpList().get(i);
			System.out.println(temp.name);

			// jsonobject/array/object순으로 세번 파싱함.

			//json_lib
			System.out.println("==========JSON LIB============");
			JSONObject obj = JSONObject.fromObject(response);//리스폰스결과 파싱
			//obj.getJSONArray("empList"); //1번 혹은 아래 2번
			JSONArray arr= (JSONArray)obj.get("empList");
			
			for (int j = 0; j < arr.size(); j++) {
			
				JSONObject temp1 = arr.getJSONObject(j);
				System.out.println(temp1.getString("name"));
			}
			}

		}

		/*
		 * for (Emp emp : empList.getEmpList()) { System.out.println(emp.getName()); }
		 */

	}



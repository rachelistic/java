package co.rachel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.common.MyRequest;

/**
 * Servlet implementation class EmpServer
 */
@WebServlet("/EmpServer")
public class EmpServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String strUrl = "http://192.168.0.79/bank/empList2.jsp";
		String result = MyRequest.get(strUrl); //리스폰스과 같으면안됨
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().append(result);
		
		
	}

}

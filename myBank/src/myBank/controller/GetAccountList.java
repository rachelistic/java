package myBank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import myBank.model.AccountList;

/**
 * Servlet implementation class GetAccountList
 */
@WebServlet("/GetAccountList")
public class GetAccountList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAccountList() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_seq_no ="1100766745";
		String access_token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzY2NzQ1Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MTQ4MzYyMzAsImp0aSI6ImE3OWI1OWY3LTljYTQtNDA2Yy1iZWExLWM4NTIxZmVhYTA1MyJ9.yYA3GQdtTt5ZupoqQkSaBx5IAla8WeJZ-adLm52ibwI";
		String result = OpenBank.getAccountList(user_seq_no, access_token);
		
		
		Gson gson = new Gson();
		AccountList accountList =gson.fromJson(result, AccountList.class);
		request.setAttribute("account_list", accountList.getRes_list());
				
		request.getRequestDispatcher("accountList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

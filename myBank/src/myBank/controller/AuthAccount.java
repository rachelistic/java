package myBank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthAccount
 */
@WebServlet("/AuthAccount")
public class AuthAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AuthAccount() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	String url ="https://testapi.openbanking.or.kr/oauth/2.0/authorize_account";
	String response_type ="code";
	String client_id ="QGLH8dEO9Pvj7FY9XgUMZuwX4ZWAhWcubdMQ17eN";
	String redirect_uri="http://localhost/myBank/Callback";
	String scope="login inquiry transfer";
	String state="12345678123456781234567812345678";
	String auth_type="0";
	
	
	StringBuilder qstr = new StringBuilder();
	qstr.append("response_type="+	response_type )
		.append("&client_id="+	client_id )
		.append("&redirect_uri="+	redirect_uri )
		.append("&scope="+	scope )
		.append("&state="+	state )
		.append("&auth_type="+	auth_type );
	response.sendRedirect(url +"?" +qstr.toString());
		
		
	
	
	
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

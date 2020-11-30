package co.rachel.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.rachel.member.dao.MemberDAO;
import co.rachel.member.vo.MemberVo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberVo vo = new MemberVo();
		MemberDAO dao = new MemberDAO();
		vo.setMemberId(request.getParameter("mid")); // 넘어왔을때 어디 담겨있낭 id 에서 옴
		vo.setPassword(request.getParameter("mpw"));
		
		HttpSession session = request.getSession(false); // 세션객체 가져옴.false로 열어달라 요청.

		vo = dao.memberLoginCheck(vo); 
		
		if(vo.getMemberAuth() != "") { 
		session.setAttribute("id", vo.getMemberId()); //세션객체에다가 id와 auto를 담아. 
		session.setAttribute("auth", vo.getMemberAuth());
		session.setAttribute("name", vo.getMemberName());
		}
		request.setAttribute("vo", vo);
		
		
		String viewPage ="/jsp/member/loginResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

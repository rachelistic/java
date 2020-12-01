package co.rachel.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.member.dao.MemberDAO;
import co.rachel.member.vo.MemberVo;

/**
 * Servlet implementation class MembeIdCheckController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MemberIdCheck.do" })
public class MembeIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembeIdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("utf-8");
		request.getParameter("userid");
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();
		
		vo.setMemberId(request.getParameter("userid"));
		int n = dao.checkId(vo);
		
		if(n!=0) {
			
			System.out.println("사용중인 이용자 아이디입니다.");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			 
			out.println("<script>alert('사용중인 사용자 아이디'); history.go(-1);</script>");
			out.flush(); 
			
		}else {
			System.out.println("사용 가능함");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			 
			out.println("<script>alert('사용가능한 아이디'); history.go(-1);</script>");
			out.flush(); 
			
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

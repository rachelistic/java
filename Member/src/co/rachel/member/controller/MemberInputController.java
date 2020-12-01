package co.rachel.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.member.dao.MemberDAO;
import co.rachel.member.vo.MemberVo;

/**
 * Servlet implementation class MemberInputController
 */
@WebServlet("/MemberInput.do")
public class MemberInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInputController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("rid"));
		vo.setMemberName(request.getParameter("rname"));
		vo.setPassword(request.getParameter("rpw1"));
		vo.setMemberAuth(request.getParameter("rauth"));
		vo.setGender(request.getParameter("rgender"));
		vo.setMemberPoint(Integer.parseInt(request.getParameter("rpoint")));
		vo.setBirthDay(Date.valueOf(request.getParameter("rbday")));
		vo.setEmail(request.getParameter("remail"));
	
		int n = dao.insert(vo);
		String viewPage;
		if(n!=0) {
			response.sendRedirect("jsp/registerResult.jsp");
			System.out.println("등록되었습니당");
			
					
		}else {
			String msg = "데이터 베이스에 정상적으로 입력하지 못했습니다.";
			request.setAttribute("msg",msg);
			viewPage = "jsp/border/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			
			System.out.println("가입 실패!");
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

package co.rachel.border.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.border.dao.BorderDao;
import co.rachel.border.vo.BorderVo;

/**
 * Servlet implementation class BorderDeleteController
 */
@WebServlet("/BorderDel.do")
public class BorderDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");//한글처리
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		vo.setBorderId(Integer.parseInt(request.getParameter("id")));
		String viewPage;
		int n = dao.delete(vo);
		if(n!=0) {response.sendRedirect("/Border/BorderList.do");}
		else {
			String msg = "글을 삭제하지 못했습니다.";
			request.setAttribute("msg",msg);
			viewPage = "jsp/border/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
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

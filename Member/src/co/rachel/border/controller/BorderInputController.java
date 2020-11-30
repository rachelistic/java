package co.rachel.border.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.border.dao.BorderDao;
import co.rachel.border.vo.BorderVo;

/**
 * Servlet implementation class BorderInputController
 */
@WebServlet("/BorderInput.do")
public class BorderInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderInputController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO command없이 여기서 다 처리함.
		
		request.setCharacterEncoding("utf-8");
		BorderDao dao = new BorderDao();
		BorderVo vo = new BorderVo();
		vo.setBorderWriter(request.getParameter("writer"));
		vo.setBorderDate(Date.valueOf(request.getParameter("wdate")));
		vo.setBorderTitle(request.getParameter("title"));
		vo.setBorderContent(request.getParameter("content"));
		int n = dao.insert(vo);
		
		String viewPage;
		if(n!=0) {
			//viewPage ="/Border/BorderList.do";
			response.sendRedirect("/Border/BorderList.do");
		}else {
			String msg = "데이터 베이스에 정상적으로 입력하지 못했습니다.";
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

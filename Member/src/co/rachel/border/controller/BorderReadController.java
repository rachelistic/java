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
 * Servlet implementation class BorderListController
 */
@WebServlet("/BorderRead.do")
public class BorderReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderReadController() {
        super();
        // TODO 
       
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO command없이 여기서 다 처리하는 방법으로 구현함. 어노테이션일때 
		 request.setCharacterEncoding("utf-8");
	        BorderDao dao = new BorderDao();
	        BorderVo vo = new BorderVo();
	        vo.setBorderId(Integer.valueOf(request.getParameter("id")));
	        vo = dao.selectOne(vo);
	        request.setAttribute("vo", vo);
	        String viewPage = "jsp/border/borderRead.jsp";
	        
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
	        
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

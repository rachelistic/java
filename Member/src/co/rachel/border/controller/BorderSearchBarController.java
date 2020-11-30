package co.rachel.border.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.border.dao.BorderDao;
import co.rachel.border.vo.BorderVo;

/**
 * Servlet implementation class BorderSearchBarController
 */
@WebServlet("/SearchBar.do")
public class BorderSearchBarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorderSearchBarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		 request.setCharacterEncoding("utf-8");	        
			int opt = Integer.valueOf(request.getParameter("opt"));
		 	String condition = request.getParameter("condition");

	        BorderDao dao = new BorderDao();
	        ArrayList<BorderVo> list = dao.selectSearch(opt, condition);
	        //뿌려준다.
	        request.setAttribute("searchList", list);
	        String viewPage = "jsp/border/searchList.jsp"; 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);

	        
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

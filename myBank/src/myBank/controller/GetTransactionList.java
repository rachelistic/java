package myBank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myBank.model.TransactionReqVo;


@WebServlet("/GetTransactionList")
public class GetTransactionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TransactionReqVo vo = new TransactionReqVo();
		//vo.set("1000");//request.getParameter("");
		vo.setAccess_token("");
		vo.setBank_tran_id("T991676590"+ "U 9자리 현재일시" );
		
		
		//System.currentTimeMillis() -> 뒤에서 9자리만 잘라서 사용
		vo.setFitech_use_num("");
		vo.setInquiry_type("A");
		vo.setInquiry_base("");
		vo.setFrom_date("2020");
		vo.setSort_order("");
		vo.setTran_dtime("");//dtime이 14자리로 넘어가고있지  yyyymmddhhmiss
		vo.setBefore_inquiry_trace_info("");
		
		
		String result = OpenBank.getTransactionList(vo);
		
		/* request.setAttribute(name, o); */
		request.getRequestDispatcher("transactionList.jsp");
		
	}

}
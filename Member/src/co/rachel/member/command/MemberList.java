package co.rachel.member.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rachel.member.controller.MemberCommand;
import co.rachel.member.dao.MemberDAO;
import co.rachel.member.vo.MemberVo;

public class MemberList implements MemberCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		MemberDAO dao = new MemberDAO();
		 ArrayList<MemberVo> list = dao.selectAll(); 
		 request.setAttribute("list", list); //request객체에 결과를 담는다.
		 return "jsp/member/memberList.jsp";
	}

}

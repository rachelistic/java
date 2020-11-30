package co.rachel.border.command;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;


import co.rachel.border.dao.BorderDao;
import co.rachel.border.vo.BorderVo;
import co.rachel.common.BorderCommand;

public class BorderList implements BorderCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		BorderDao dao = new BorderDao();
		 ArrayList<BorderVo> blist = dao.selectAll(); 
		 request.setAttribute("list", blist); //request객체에 결과를 담는다.
		return "jsp/border/borderList.jsp";
	}

}

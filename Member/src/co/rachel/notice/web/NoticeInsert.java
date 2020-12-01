package co.rachel.notice.web;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import co.rachel.notice.dao.NoticeDao;
import co.rachel.notice.vo.NoticeVo;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/NoticeInsert.do")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10MB	
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100) //100 MB
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR ="uploadFile";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		NoticeDao dao = new NoticeDao();
		NoticeVo vo = new NoticeVo();
		
		HttpSession session = request.getSession();
		vo.setNoticeWriter((String) session.getAttribute("name"));
		//vo.setNoticeWriter(session.getAttribute("auth"));
		vo.setNoticeTitle(request.getParameter("title"));
		vo.setNoticeContent(request.getParameter("content"));
		//파일경로
		String applicationPath = request.getServletContext().getRealPath("/");
		String uploadFilePath = applicationPath + UPLOAD_DIR; //"uploadFile"
		
		System.out.println(" LOG :: [파일 저장 경로] :: " + uploadFilePath);
		File fileSaveDir = new File(uploadFilePath);
		
		String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            System.out.println(" LOG :: [ 업로드 파일 경로 ] :: " + uploadFilePath + File.separator + fileName);
            part.write(uploadFilePath + File.separator + fileName);
        }
        request.setAttribute("fileName", fileName);
        getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
	}
					
		

	private String getFileName(Part part) {  String contentDisp = part.getHeader("content-disposition");
    System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
    String[] tokens = contentDisp.split(";");
    for (String token : tokens) {
        if (token.trim().startsWith("filename")) {
        	System.out.println(" LOG :: 파일 이름 :: " + token);
            return token.substring(token.indexOf("=") + 2, token.length()-1);
        }
    }
    return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

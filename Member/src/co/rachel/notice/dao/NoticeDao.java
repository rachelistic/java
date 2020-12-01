package co.rachel.notice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.rachel.notice.vo.NoticeVo;

public class NoticeDao {

	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "rach";
	String password = "1234";

	private Connection conn;

	private PreparedStatement psmt;
	private ResultSet rs;

	// 시퀼 만들어줌.
	private final String NOTICELIST = "SELECT * FROM NOTICE";
	private final String INSERT = 
	         "INSERT INTO NOTICE(NOTICEID,NOTICEWRITER,NOTICETITLE,NOTICECONTENT,NOTICEATTATCH) VALUES(NO_VAL.NEXTVAL,?,?,?,?)";	
	public NoticeDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			System.out.println("DB연결 실패");
		}

	}

	
	private void close() {
		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 

	public ArrayList<NoticeVo> selectAll(){
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		NoticeVo vo;
		try {
			psmt = conn.prepareStatement(NOTICELIST);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVo();
				vo.setNoticeId(rs.getInt("noticeid"));
				vo.setNoticeTitle(rs.getString("noticetitle"));
				vo.setNoticeContent(rs.getString("noticecontent"));
				vo.setNoticeWriter(rs.getNString("noticewriter"));
				vo.setNoticeDate(rs.getDate("noticedate"));
				vo.setNoticeHit(rs.getInt("noticehit"));
				vo.setNoticeAttach(rs.getString("noticeattach"));
				list.add(vo);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;  // 다 끝나면 list로 리턴 ! 
	} 
	
	public NoticeVo select(NoticeVo vo) {
		return vo;
	}
	public NoticeVo insert(NoticeVo vo) {
		int n = 0;
		
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setNString(1, vo.getNoticeWriter());
			psmt.setString(2, vo.getNoticeTitle());
			psmt.setString(3, vo.getNoticeContent());
			psmt.setString(4, vo.getNoticeAttach());
			
		} catch (Exception e) {
			e.printStackTrace(); 	
		}finally {
			close();
		}
		
		return n;
	}
	public NoticeVo update(NoticeVo vo) {
		int n = 0;
		
		return n;
	}
	public NoticeVo delete(NoticeVo vo) {
		int n = 0;
		
		return n;
	}
	
	
	
	
}

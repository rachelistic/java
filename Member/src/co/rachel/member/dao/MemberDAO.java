package co.rachel.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.rachel.member.vo.MemberVo;

public class MemberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "rach";
	String password = "1234";

	private Connection conn;

	private PreparedStatement psmt;
	private ResultSet rs;

	// 시퀼 만들어줌.

	public MemberDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			System.out.println("DB연결 실패");
		}

	}

	private final String SELECT_ALL = "SELECT * FROM MEMBER";
	private final String MEMBERLOGIN = "SELECT * FROM MEMBER WHERE MEMBERID=? AND PASSWORD =?";
	private final String INSERT = "INSERT INTO MEMBER(MEMBERID,MEMBERNAME,PASSWORD,MEMBERAUTH,GENDER,MEMBERPOINT,BIRTHDAY,EMAIL)"
			 		+ "VALUES(?,?,?,?,?,?,?,?)";
	private final String CHECKID = "SELECT * FROM MEMBER WHERE MEMBERID=?";
	
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<MemberVo> selectAll() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
			MemberVo vo;	
			try {
				psmt = conn.prepareStatement(SELECT_ALL);
				rs = psmt.executeQuery();
				while (rs.next()) {
					vo = new MemberVo();
					vo.setMemberId(rs.getString("memberid"));
					vo.setMemberName(rs.getString("membername"));
					vo.setPassword(rs.getString("password"));
					vo.setMemberAuth(rs.getString("memberauth"));
					vo.setGender(rs.getString("gender"));
					vo.setMemberPoint(rs.getInt("memberpoint"));
					vo.setBirthDay(rs.getDate("birthday"));
					vo.setEmail(rs.getString("email"));
					list.add(vo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;

		}


	public MemberVo select(MemberVo vo) {
		return vo;
	}

	public MemberVo memberLoginCheck(MemberVo vo) {// login check
		
		try {
			psmt = conn.prepareStatement(MEMBERLOGIN);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getPassword());

			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));

				System.out.println(rs.getString("membername"));
				System.out.println(rs.getString("memberauth"));
			} else {
				System.out.println("값없음");
			}

		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	public int insert(MemberVo vo) {
		int n = 0;
		try { 
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getMemberAuth());
			psmt.setString(5, vo.getGender());
			psmt.setInt(6, vo.getMemberPoint());
			psmt.setDate(7, vo.getBirthDay());
			psmt.setNString(8, vo.getEmail());
			n=psmt.executeUpdate();
			System.out.println("가입완료");
		} catch (Exception e) {
			e.printStackTrace();	
			System.out.println("가입실패");
		}finally{
			close();
		}
		return n;
	}

	public int update(MemberVo vo) {
		int n = 0;
		return n;
	}

	public int delete(MemberVo vo) {
		int n = 0;
		return n;
	}

	public int checkId(MemberVo vo) {
		
		int n = 0;
		
		try {			
			psmt = conn.prepareStatement(CHECKID);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

}

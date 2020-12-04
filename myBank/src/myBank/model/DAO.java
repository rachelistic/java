package myBank.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "rach";
	String password = "1234";

	private Connection conn;

	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	
	

	
	
	
	
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			System.out.println("DB연결 실패");
		}

	}
	
	private final String SELECT_ALL ="SELECT * FROM user_account";
	private final String INSERT = "INSERT INTO user_account(user_seq_no,acct_no,fintech_use_num,account_alias,bank_code_std,bank_name,account_num,account_type,account_state,inquiry_agree_yn,transfer_agree_yn)"
	 		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
	
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
	
	
	
	
	
	
	
	public ArrayList<Account> selectAll() {
	      ArrayList<Account> list = new ArrayList<Account>();
	      Account vo;

	      try {
	         psmt = conn.prepareStatement(SELECT_ALL); 
	         rs = psmt.executeQuery(); 

	         while (rs.next()) {
	            vo = new Account(); // 돌아오는 데이터가 존재하면 Vo를 초기화 (인스턴스 초기화)
	            
	            vo.setUser_seq_no(rs.getString("USER_SEQ_NO"));
	            vo.setAccount_num_masked(rs.getString("ACCOUNT_NUM")); //DB는 account_num 인데 vo에 masked
	            vo.setFintech_use_num(rs.getString("FINTECH_USE_NUM"));
	            vo.setAccount_alias(rs.getString("ACCOUNT_ALIAS"));
	            vo.setBank_code_std(rs.getString("BANK_CODE_STD"));
	            vo.setBank_name(rs.getString("BANK_NAME"));
	            //vo.setAccount_num_masked(rs.getString("ACCOUNT_NUM"));
	            vo.setAccount_type(rs.getString("ACCOUNT_TYPE"));
	            vo.setAccount_state(rs.getString("ACCOUNT_STATE"));
	            vo.setInquiry_agree_yn(rs.getString("INQUIRY_AGREE_YN"));
	            vo.setTransfer_agree_yn(rs.getString("TRANSFER_AGREE_YN"));
	            
	            list.add(vo);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return list; // 나한테 리스트로 돌려줌
	   }
	   


	
	
	
	public int insert(Account vo) {
		int n = 0;
		
		try {
			 psmt = conn.prepareStatement(INSERT);
			 
	         psmt.setString(1, vo.getUser_seq_no());
	         psmt.setString(2, vo.getAccount_num_masked());
	         psmt.setString(3, vo.getFintech_use_num());
	         psmt.setString(4, vo.getAccount_alias());
	         psmt.setString(5, vo.getBank_code_std());
	         psmt.setString(6, vo.getBank_name());
	         psmt.setString(7, vo.getAccount_num_masked());
	         psmt.setString(8, vo.getAccount_type());
	         psmt.setString(9, vo.getAccount_state());
	         psmt.setString(10, vo.getInquiry_agree_yn());
	         psmt.setString(11, vo.getTransfer_agree_yn());

			
		
			n=psmt.executeUpdate();
			System.out.println("등록완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록 실패");
			
		}finally {
			close();
		}
		return n;
	}
	
	
	
	
}

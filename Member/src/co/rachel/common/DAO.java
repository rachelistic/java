package co.rachel.common;
import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {
	//슈퍼 클래스, 최상위 클래스 DAO!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "rach";
	String password = "1234";
	
	public Connection conn;
	
	public DAO() {
		try {
	         Class.forName(driver); //드라이버 로드 
	         conn = DriverManager.getConnection(url, user, password);
	         System.out.println("연결 성공 ~~~");
	         
	      }catch(Exception e) {
	         e.printStackTrace(); //어떤 오류가 떴는지 알수있음
	         System.out.println("DB연결 실패 !!!");
	      }
		
	}

}

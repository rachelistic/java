package co.rachel.border.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.rachel.border.vo.BorderVo;
import co.rachel.common.DAO;

public class BorderDao extends DAO {

	// 보더가 만들어질 dao자리
	private PreparedStatement psmt;
	private ResultSet rs;

	
	
	private final String SELECT_ALL = "SELECT * FROM BORDER ORDER BY 1 ASC"; // 대문자로 바꿔줌
	
	private final String SELECT_ONE = "SELECT * FROM BORDER WHERE borderID = ?" ;
	
	private final String INSERT ="INSERT INTO BORDER(BORDERID, BORDERWRITER,BORDERTITLE,BORDERCONTENT,BORDERDATE)" 
			+ "VALUES(B_SEQ.NEXTVAL,?,?,?,?)";
	
	private final String HIT_UPDATE = "UPDATE BORDER SET BORDERHIT = BORDERHIT +1 WHERE BORDERID= ?";
	
	private final String UPDATE = "UPDATE BORDER SET BORDERDATE = ?, BORDERCONTENT=? WHERE BORDERID =? ";

	private final String DELETE_ONE = "DELETE FROM BORDER WHERE BORDERID =? ";
	
	
	private final String SEARCHTITLE ="SELECT * FROM BORDER WHERE borderTitle like ? ORDER BY 1 ASC ";
	private final String SEARCHWRITER ="SELECT * FROM BORDER WHERE borderWriter like ? ORDER BY 1 ASC ";
	private final String SEARCHCONTENT ="SELECT * FROM BORDER WHERE borderContent like ? ORDER BY 1 ASC ";
	
	public ArrayList<BorderVo> selectAll() { // 전체 리스트 가져오기
		ArrayList<BorderVo> list = new ArrayList<BorderVo>();
		BorderVo vo;	
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BorderVo();
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWriter(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	private void close() {
		try {
			if (rs != null)rs.close();
			if (psmt != null)psmt.close();
			if (conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	//위에 sql문 만들어주고 아래 생성한것 한줄이니 while > if로 고침
	public BorderVo selectOne(BorderVo vo) { //한개의 레코드 보더보로 서치
		try { 
			psmt = conn.prepareStatement(SELECT_ONE);
			psmt.setInt(1, vo.getBorderId());
			rs = psmt.executeQuery();
			if(rs.next()) { //한레코드라서 if
				psmt=conn.prepareStatement(HIT_UPDATE);
				psmt.setInt(1, vo.getBorderId());
				psmt.execute(); //조회수를 1 증가한다.
				
				vo = new BorderVo();
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWriter(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
			}
			}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	
	public int insert(BorderVo vo) {
		// TODO Auto-generated method stub
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getBorderWriter());
			psmt.setString(2, vo.getBorderTitle());
			psmt.setString(3, vo.getBorderContent());
			psmt.setDate(4, vo.getBorderDate());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	public BorderVo selectSearch(BorderVo vo) { //한레코드 검색만
		try {
			psmt = conn.prepareStatement(SELECT_ONE);
			psmt.setInt(1, vo.getBorderId());
			rs = psmt.executeQuery();
			if(rs.next()) { //한레코드라서 if
				
				vo = new BorderVo();
				vo.setBorderId(rs.getInt("borderid"));
				vo.setBorderWriter(rs.getString("borderwriter"));
				vo.setBorderTitle(rs.getString("bordertitle"));
				vo.setBorderContent(rs.getString("bordercontent"));
				vo.setBorderDate(rs.getDate("borderdate"));
				vo.setBorderHit(rs.getInt("borderhit"));
			}
			}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
		
	}

	public int update(BorderVo vo) { //게시글 수정 
		int n = 0;
		try {
			psmt = conn.prepareStatement(UPDATE);
			psmt.setDate(1, vo.getBorderDate());
			psmt.setString(2, vo.getBorderContent());
			psmt.setInt(3, vo.getBorderId());
			n = psmt.executeUpdate();
			 
		}catch(SQLException e) {
			 e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	public int delete(BorderVo vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(DELETE_ONE);
			psmt.setInt(1, vo.getBorderId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
		
	}
	
	
	

		public ArrayList<BorderVo> selectSearch(int opt, String condition) { // 서치리스트 가져오기
			ArrayList<BorderVo> list = new ArrayList<BorderVo>();
			BorderVo vo;	
			
			if(opt==0) {
				
				try {
					psmt = conn.prepareStatement(SEARCHTITLE);
					psmt.setString(1, "%" + condition + "%" );
					rs = psmt.executeQuery();
					
					while (rs.next()) {
						vo = new BorderVo();
						vo.setBorderId(rs.getInt("borderid"));
						vo.setBorderWriter(rs.getString("borderwriter"));
						vo.setBorderTitle(rs.getString("bordertitle"));
						vo.setBorderContent(rs.getString("bordercontent"));
						vo.setBorderDate(rs.getDate("borderdate"));
						vo.setBorderHit(rs.getInt("borderhit"));
						list.add(vo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return list;
				
			}else if(opt==1){
				
				try {
					psmt = conn.prepareStatement(SEARCHWRITER);
					psmt.setString(1, "%" + condition + "%" );
					rs = psmt.executeQuery();
					
					while (rs.next()) {
						vo = new BorderVo();
						vo.setBorderId(rs.getInt("borderid"));
						vo.setBorderWriter(rs.getString("borderwriter"));
						vo.setBorderTitle(rs.getString("bordertitle"));
						vo.setBorderContent(rs.getString("bordercontent"));
						vo.setBorderDate(rs.getDate("borderdate"));
						vo.setBorderHit(rs.getInt("borderhit"));
						list.add(vo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return list;
			}else if(opt==2) {
				try {
					psmt = conn.prepareStatement(SEARCHCONTENT);
					psmt.setString(1, "%" + condition + "%" );
					rs = psmt.executeQuery();
					
					while (rs.next()) {
						vo = new BorderVo();
						vo.setBorderId(rs.getInt("borderid"));
						vo.setBorderWriter(rs.getString("borderwriter"));
						vo.setBorderTitle(rs.getString("bordertitle"));
						vo.setBorderContent(rs.getString("bordercontent"));
						vo.setBorderDate(rs.getDate("borderdate"));
						vo.setBorderHit(rs.getInt("borderhit"));
						list.add(vo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return list;
				
				
			}else {
				System.out.println("오류메세지");
				
			}
			
			return list;
	

		}
	
}

package T3_Hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO {
	private HoewonVO vo = null;
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springgroup";
	private String user = "atom";
	private String password = "1234";
	
	private String sql = "";
	
	public HoewonDAO() {
	  try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결에 실패했습니다.");
		}
	}
	
	// connection객체 닫기
	public void connClose() {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	
//	stmt객체 닫기
	public void stmtClose() {
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {}
	}
	
//	rs객체 닫기
	public void rsClose() {
		if(rs != null)
			try {
				rs.close();
				stmtClose();
			} catch (SQLException e) {}
	}

	// 개별 회원 조회
	public HoewonVO getNameSearch(int idx) {
		vo = new HoewonVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon where idx = "+idx;
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
			}
			else vo = null;
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 회원 가입처리(insert)
	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			sql = "insert into hoewon values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getAddress()+"')";
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		return res;
	}

	// 회원자료 삭제처리
	public int setHoewonDelete(String name) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			sql = "delete from hoewon where name = '"+name+"'";
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		return res;
	}

	// 회원 전체 리스트
	public ArrayList<HoewonVO> getHoewonList() {
		ArrayList<HoewonVO> vos = new ArrayList<HoewonVO>();
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon order by name";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new HoewonVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 회원 정보 수정
	public int setHoewonUpdate(int idx, int select, String content) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			if(select == 1) {
				sql = "update hoewon set name = '"+content+"' where idx = "+idx;
			}
			else if(select == 2) {
				sql = "update hoewon set age = "+Integer.parseInt(content)+" where idx = "+idx;
			}
			else if(select == 3) {
				sql = "update hoewon set gender = '"+content+"' where idx = "+idx;
			}
			else if(select == 4) {
				sql = "update hoewon set address = '"+content+"' where idx = "+idx;
			}
			res = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
		return res;
	}
}

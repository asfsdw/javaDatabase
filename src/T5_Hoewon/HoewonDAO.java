package T5_Hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class HoewonDAO {
	private HoewonVO vo = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	int res = 0;
	
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
	public void pstmtClose() {
		if(pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {}
	}
	
//	rs객체 닫기
	public void rsClose() {
		if(rs != null)
			try {
				rs.close();
				pstmtClose();
			} catch (SQLException e) {}
	}

	// 개별 회원 조회
	public HoewonVO getNameSearch(int idx) {
		vo = new HoewonVO();
		try {
			sql = "select * from hoewon where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
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
		res = 0;
		try {
			sql = "insert into hoewon values (default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getAddress());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 회원자료 삭제처리
	public int setHoewonDelete(int idx) {
		res = 0;
		try {
			sql = "delete from hoewon where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 회원 전체 리스트
	public ArrayList<HoewonVO> getHoewonList() {
		ArrayList<HoewonVO> vos = new ArrayList<HoewonVO>();
		try {
			sql = "select * from hoewon order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
		res = 0;
		try {
			if(select == 1) {
				sql = "update hoewon set name = ? where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
			}
			else if(select == 2) {
				sql = "update hoewon set age = ? where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(content));
			}
			else if(select == 3) {
				sql = "update hoewon set gender = ? where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
			}
			else if(select == 4) {
				sql = "update hoewon set address = ? where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, content);
			}
			pstmt.setInt(2, idx);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 동명이인 체크
	public HoewonVO getNameCheck(String name) {
		vo = new HoewonVO();
		String regName = "^[가-힣]{2,20}$";
		
		if(Pattern.matches(regName, name)) {
			try {
				sql = "select * from hoewon where name = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(rs.next()) {
						vo.setIdx(rs.getInt("idx"));
						vo.setName(rs.getString("name"));
						vo.setAge(rs.getInt("age"));
						vo.setGender(rs.getString("gender"));
						vo.setAddress(rs.getString("address"));
					}
				}
				else vo = null;
				
			} catch (SQLException e) {
				System.out.println("SQL 오류 : " + e.getMessage());
			} finally {
				rsClose();
			}
		}
		else {
			System.out.println("이름은 한글, 20자 이내로 기입해주세요.\n");
			// vo에 null을 주면 service 객체에서 걸리기 때문에 입력한 이름을 vo에 넣어 돌려준다.
			vo.setName(name);
		}
		return vo;
	}
}

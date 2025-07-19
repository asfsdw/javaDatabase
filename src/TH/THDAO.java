package TH;

import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class THDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	String sql = "";
	
	public int originFieldMoney = 10, fieldMoney = originFieldMoney;
	
	public THDAO() {
		String url = "jdbc:mysql://localhost:3306/springgroup",
				user = "atom", password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB에 연결되지 않았습니다.");
		}
	}
	public void connClose() {
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {}
	}
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
		} catch (Exception e) {}
	}
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				pstmtClose();
			}
		} catch (Exception e) {}
	}
	
//	플레이어 리스트
	public Vector getPlList() {
		Vector vData = new Vector();
		try {
			sql = "select * from texas_holdem";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("point"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getPlList) : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

//	레이즈 처리
	public int Raise(String name) {
		int res = 0;
		try {
			sql = "update texas_holdem set point = point - ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fieldMoney * 2);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			
			sql = "select point from texas_holdem where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) res = rs.getInt("point");
		} catch (SQLException e) {
			System.out.println("sql오류(Raise) : "+e.getMessage());
		} finally {
			fieldMoney += fieldMoney*2;
			rsClose();
		}
		return res;
	}
//	콜 처리
	public int Call(String name) {
		int res = 0;
		try {
			sql = "update texas_holdem set point = point - ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fieldMoney);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			
			sql = "select point from texas_holdem where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) res = rs.getInt("point");
		} catch (SQLException e) {
			System.out.println("sql오류(Call) : "+e.getMessage());
		} finally {
			rsClose();
			fieldMoney += fieldMoney;
		}
		return res;
	}
	
//	포인트 정산
	public int pointResult(String name) {
		int res = 0;
		try {
			sql = "update texas_holdem set point = point + ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fieldMoney);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			
			sql = "select point from texas_holdem where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) res = rs.getInt("point");
		} catch (SQLException e) {
			System.out.println("sql오류(Call) : "+e.getMessage());
		} finally {
			rsClose();
		}
		return res;
	}

//	계정정보입력
	public int setAccountCreate(THVO vo) {
		int res = 0;
		try {
			sql = "insert into texas_holdem values (default,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setAccountCreate) : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

//	계정삭제
	public int setAccountDelete(String id) {
		int res = 0;
		try {
			sql = "delete from texas_holdem where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setAccountDelete) : "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
//	아이디 중복검사
	public THVO getIdSearch(String id) {
		THVO vo = new THVO();
		try {
			sql = "select * from texas_holdem where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
			}
			else vo = null;
		} catch (SQLException e) {
			System.out.println("sql오류(getIdSearch) : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
}

package TH;

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
	
	public int fieldMoney = 10;
	
	public THDAO() {
		System.out.println("db연결중.");
		String url = "jdbc:mysql://localhost:3306/springgroup",
				user = "atom", password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 완료");
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
		System.out.println("오류0");
		try {
			System.out.println("오류1");
			sql = "select * from texas_holdem";
			System.out.println("오류2");
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			System.out.println("오류3");
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
	
//	플레이어의 현재 포인트
	public int PlPoint() {
		int point = 0;
		sql = "select * from TH where point";
		return point;
	}

//	레이즈 처리
	public void Raise() {
		sql = "update TH set point = point -"+(fieldMoney*2);
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("sql오류(Raise) : "+e.getMessage());
		} finally {
			pstmtClose();
		}
	}
}

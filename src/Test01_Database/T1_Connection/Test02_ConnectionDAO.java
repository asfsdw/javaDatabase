package Test01_Database.T1_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 1.JDBC 드라이버를 다운로드 받아서 작업 프로젝트에 등록시킨다.
public class Test02_ConnectionDAO {
	Connection conn = null;
	
	public Test02_ConnectionDAO() {
		String url = "jdbc:mysql://localhost:3306/springgroup",
				user = "atom", password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver 검색에 성공했습니다.");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB서버에 연결되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver 검색에 실패했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB서버 연결에 실패했습니다.");
		}	finally {
			System.out.println("DB작업이 종료되었습니다.");
		}
	}
	
	public void connClose() {
		try {
			if(conn != null) {
				conn.close();
				System.out.println("DB서버와의 연결이 종료되었습니다.");
			}
		} catch (SQLException e) {}
	}
}

package T1_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 1.JDBC 드라이버를 다운로드 받아서 작업 프로젝트에 등록시킨다.
public class Test01_ConnectionDAO {
	static Connection conn = null;
	public Test01_ConnectionDAO() {
		try {
//		2.JDBC 드라이버가 잘 들어왔는지 검색해본다.
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver 검색에 성공했습니다.");
			
//		3. DB서버에 연결(연동) 후, 데이터베이스 사용 준비 유무확인.
			String url = "jdbc:mysql://localhost:3306/springgroup",
					user = "atom", password = "1234";
//			Connection conn = DriverManager.getConnection(url, user, password);
			DriverManager.getConnection(url, user, password);
			System.out.println("DB서버에 연결되었습니다.");
			// 4. DB 안의 Table 사용 처리.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver 검색에 실패했습니다.");
		}
			catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB서버 연결에 실패했습니다.");
		}	finally {
			System.out.println("작업이 종료되었습니다.");
		}
//		conn.close();
	}
}

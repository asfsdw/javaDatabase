package Test01_Database.T2_Hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoewonDAO {
	Scanner scanner = new Scanner(System.in);
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int age = 0;
	private String name = "", gender = "", address = "";
	
	private String driver = "com.mysql.jdbc.Driver",
			url = "jdbc:mysql://localhost:3306/springgroup",
			user = "atom", password = "1234", sql = "";
	
	public HoewonDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB연결에 실패했습니다.");
		}
	}
	
	public void connClose() {
		try {if(conn != null) conn.close();}
		catch (SQLException e) {}
	}

//	개별 회원 조회
	public List<HoewonVO> getNameSerch(String name) {
    List<HoewonVO> vos = new ArrayList<HoewonVO>();
    try {
      stmt = conn.createStatement();
      sql = "select * from hoewon where name = '"+name+"'";
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
      	HoewonVO vo = new HoewonVO();
        vo.setidx(rs.getInt("idx"));
        vo.setName(rs.getString("name"));
        vo.setAge(rs.getInt("age"));
        vo.setGender(rs.getString("gender"));
        vo.setAddress(rs.getString("address"));
        vos.add(vo);
      }
    } catch (SQLException e) {
      	System.out.println("SQL 오류:"+e.getMessage());
    }
    return vos;
}


//	회원 가입
	public void setHoewonInput() {
		System.out.println("회원님의 이름을 입력하세요.");
		System.out.print("입력> ");
		name = scanner.next();
		System.out.println();
		System.out.println("회원님의 나이를 입력하세요.");
		System.out.print("입력> ");
		age = scanner.nextInt();
		System.out.println();
		System.out.println("회원님의 성별을 입력하세요.");
		System.out.print("입력> ");
		gender = scanner.next();
		System.out.println();
		System.out.println("회원님의 주소를 입력하세요.");
		System.out.print("입력> ");
		address = scanner.next();
		System.out.println();
		
		try {
			stmt = conn.createStatement();
			sql = "insert into hoewon values (default, '"+name+"', '"+age+"', '"+gender+"', '"+address+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류:"+e.getMessage());
		}
	}

	public int setHoewonDelete(String name) {
		int res = 0;
		try {
			stmt = conn.createStatement();
			sql = "delete from hoewon where name = '"+name+"'";
			res = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL 오류:"+e.getMessage());
		}
		return res;
	}
}

package Test01_Database.T1_Connection;

public class Test01_ConnectionDAORun {
	public static void main(String[] args) {
		Test02_ConnectionService service = new Test02_ConnectionService();
		
		System.out.println("1.메인화면 실행.");
		Test02_ConnectionDAO t2 = new Test02_ConnectionDAO();
		service.Test02_method();
		t2.connClose();
		System.out.println("3.t2 메인 객체 작업종료.");
	}
}

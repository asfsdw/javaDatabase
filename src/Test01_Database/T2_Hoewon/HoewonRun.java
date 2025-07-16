package Test01_Database.T2_Hoewon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoewonDAO dao = new HoewonDAO();
		List<HoewonVO> vos = new ArrayList<HoewonVO>();
		
		int select = 0, res = 0;
		String name = "";
		boolean run = true;
		
		while(run) {
		System.out.println("1.가입 | 2.조회 | 3.삭제 | 0.종료");
		System.out.print("선택> ");
		select = scanner.nextInt();
		System.out.println();
		
			switch (select) {
//				회원가입
				case 1:
					dao.setHoewonInput();
					System.out.println("가입이 완료되었습니다.");
					break;
					
//				회원조회
				case 2:
			    System.out.println("검색할 회원의 이름을 입력하세요.");
			    System.out.print("입력> ");
			    name = scanner.next();
			    System.out.println();
			 
			    vos = dao.getNameSerch(name);
			    System.out.println("검색 결과");
			    if(vos.size() > 0) {
		        for(HoewonVO serch : vos) {
	            System.out.println(serch);
		        }
		        System.out.println();
			    }
			    else System.out.println("검색된 자료가 없습니다.\n");
			    break;

					
//				회원삭제
				case 3:
					System.out.println("검색할 회원이 이름을 입력하세요.");
					System.out.print("입력> ");
					name = scanner.next();
					System.out.println();
					
					res = dao.setHoewonDelete(name);
					if(res != 0) {
						System.out.println("회원이 삭제되었습니다.\n");
					}
					else System.out.println("삭제할 자료가 없습니다.\n");
					break;

				default:
					System.out.println("프로그램이 종료되었습니다.\n");
					run = false;
					break;
			}
		}
//		hoewonDB에서 '홍길동'자료 검색.
		
		scanner.close();
		dao.connClose();
	}
}

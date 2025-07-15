package T4_Hoewon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoewonService service = new HoewonService();
		
		int choice = 0;
		boolean run = true;
		
		while(run) {
			try {
				System.out.println("1:회원가입 | 2:전체조회 | 3:개별조회 | 4:회원수정 | 5:회원삭제 | 0:종료");
				System.out.print("선택> ");
				choice = scanner.nextInt();
				System.out.println();
				
				switch (choice) {
					case 1:
						service.setHoewonInput();
						break;
					case 2:
						service.getHoewonList();
						break;
					case 3:
						service.getHoewonSearch();
						break;
					case 4:
						service.setHoewonUpdate();
						break;
					case 5:
						service.setHoewonDelete();
						break;
					default:
						service.connClose();
						run = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("메뉴로 정해진 숫자를 입력해주세요.\n");
				scanner.next();
				continue;
			}
		}
		System.out.println("작업 종료.");
		
		scanner.close();
	}
}

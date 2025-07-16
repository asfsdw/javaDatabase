package Test01_Database.T4_Hoewon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HoewonService {
	Scanner scanner = new Scanner(System.in);
	HoewonDAO dao = new HoewonDAO();
	HoewonVO vo = null;

	int idx, age, select, res = 0, line = 60;
	String name = "", gender = "", address = "", ageR = "", content;

	// 회원 가입 처리
	public void setHoewonInput() {
		while(true) {
			String regName = "^[가-힣]{2,20}$";
			System.out.println("이름을 입력해주세요.");
			System.out.print("입력> ");
			name = scanner.next();
			System.out.println();
			
			if(Pattern.matches(regName, name)) break;
			else {
				System.out.println("이름은 한글, 20자 이내로 기입해주세요.\n");
				continue;
			}
		}
		
		while(true) {
			try {
				System.out.println("나이를 입력해주세요.");
				System.out.print("입력> ");
				age = scanner.nextInt();
				System.out.println();
				
				if(age > 0 && age < 130) break;
				else {
					System.out.println("나이는 1~129살 이내로 기입해주세요.\n");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("나이는 숫자로 입력해주세요.\n");
				scanner.next();
				continue;
			}
		}
		
		while(true) {
			System.out.println("성별을 '남자' 혹은 '여자'으로 입력해주세요.");
			System.out.print("입력> ");
			gender = scanner.next();
			System.out.println();
			
			if(gender.equals("남자") || gender.equals("여자")) break;
			else {
				System.out.println("성별은 '남자', 혹은 '여자'로 기입해주세요.\n");
				continue;
			}
		}
		
		while(true) {
			String regAddress = "^[가-힣]{2,30}$";
			System.out.println("주소를 입력해주세요.");
			System.out.print("입력> ");
			address = scanner.next();
			System.out.println();
			
			if(Pattern.matches(regAddress, address)) break;
			else {
				System.out.println("주소는 한글, 30자 이내로 기입해주세요.\n");
				continue;
			}
		}
		
		vo = new HoewonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		res = dao.setHoewonInput(vo);
		
		if(res != 0) System.out.println("회원가입이 완료되었습니다.\n");
		else System.out.println("회원가입에 실패했습니다.\n");
	}

	// 개별 조회
	public void getHoewonSearch() {
		while(true) {
			try {
				System.out.println("검색할 회원의 번호를 입력해주세요");
				System.out.print("입력> ");
				idx = scanner.nextInt();
				System.out.println();
				break;
			} catch (InputMismatchException e) {
				System.out.println("회원번호를 숫자로 입력해주세요.\n");
				scanner.next();
				return;
			}
		}
		vo = dao.getNameSearch(idx);
		
		System.out.println("검색 결과");
		if(vo != null) {
			subTitle(line);
			System.out.print(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getAge()+"\t"+vo.getGender()+"\t"+vo.getAddress()+"\n");
			System.out.println();
		}
		else System.out.println("검색된 자료가 없습니다.\n");
	}

	// 회원 삭제
	public void setHoewonDelete() {
		System.out.println("삭제할 회원의 번호 입력해주세요.");
		System.out.print("입력> ");
		idx = scanner.nextInt();
		System.out.println();
		
		res = dao.setHoewonDelete(idx);
		
		if(res != 0) System.out.println("삭제가 완료되었습니다.\n");
		else System.out.println("회원을 찾지 못했습니다.\n");
	}

	// 전체 조회
	public void getHoewonList() {
		getMainTitle(line);
		ArrayList<HoewonVO> vos = dao.getHoewonList();
		for(int i=0; i<vos.size(); i++) {
			System.out.print(vos.get(i).getIdx()+"\t"+vos.get(i).getName()+"\t"+vos.get(i).getAge()+"\t"+vos.get(i).getGender()+"\t"+vos.get(i).getAddress()+"\n");
		}
		LineMethod(line);
		System.out.println();
	}

	// 회원 정보 수정
	public void setHoewonUpdate() {
		while(true) {
			try {
				System.out.println("수정할 회원의 번호를 입력해주세요");
				System.out.print("입력> ");
				idx = scanner.nextInt();
				System.out.println();
				break;
			} catch (InputMismatchException e) {
				System.out.println("회원번호는 양수값으로 입력해주세요.\n");
				scanner.next();
				return;
			}
		}
		vo = dao.getNameSearch(idx);
		
		System.out.println("검색 결과");
		if(vo != null) {
			subTitle(line);
			System.out.print(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getAge()+"\t"+vo.getGender()+"\t"+vo.getAddress()+"\n");
			System.out.println();
		}
		else {
			System.out.println("검색된 자료가 없습니다.\n");
			return;
		}
		
		System.out.println("수정할 항목을 결정해주세요.");
		System.out.println("1.이름 | 2.나이 | 3.성별 | 4.주소");
		System.out.print("선택> ");
		select = scanner.nextInt();
		System.out.println();
		
		if(select == 3) {
			System.out.println("수정할 내용을 입력해주세요.");
			System.out.println("1.남자 | 2.여자");
			System.out.print("선택> ");
			select = scanner.nextInt();
			content = select == 1 ? "남자" : "여자";
		}
		else {
			System.out.println("수정할 내용을 입력해주세요.");
			System.out.print("입력> ");
			content = scanner.next();
		}
		res = dao.setHoewonUpdate(vo.getIdx(), select, content);
		
		if(res != 0) System.out.println("회원정보 수정이 완료되었습니다.\n");
		else System.out.println("회원정보 수정에 실패했습니다.\n");
	}
	
	// 라인 출력
	private void LineMethod(int line) {
		System.out.println("=".repeat(line));
	}
	
	// 리스트 제목 출력
	private void getMainTitle(int line) {
		System.out.println("\t\t*** 전 체 회 원 리 스 트 ***");
		subTitle(line);
	}

	// 부제목 출력
	private void subTitle(int line) {
		LineMethod(line);
		System.out.println("번호\t이름\t나이\t성별\t주소");
		LineMethod(line);
	}
	
	// 작업 종료
	public void connClose() {
		dao.connClose();
	}
}

package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.util.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		/*
		 * 	Scanner 객체를 이용해서 검색할 회원 번호를 입력 받아
		 * 	번호에 해당되는 회원 정보를 얻어와서
		 * 	아래와 같은 형식으로 출력하기
		 * 
		 * 	1을 입력했을 때
		 * 
		 * 	1 | name | addr
		 * 
		 * 	입력한 번호의 row가 없는 경우
		 * 
		 * 	입력한 번호의 회원은 존재하지 않습니다
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("회원 번호를 입력하세요: ");
		int num = scan.nextInt();
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = dao.getData(num);
		
		if(dto == null) {
			System.out.println(num + "번 회원의 정보가 없습니다");
		}else {
			System.out.println(dto.getNum() + " | " + dto.getName() + " | " + dto.getAddr());
		}
	}
}

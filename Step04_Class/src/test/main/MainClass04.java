package test.main;

import test.mypac.Member;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 1, 허남영, 봉천동
		 * 
		 * 이라는 int, String, String type의 값을
		 * 
		 * 객체의 필드에 저장하는 프로그래밍을 해보기
		 * 
		 * 단, 객체를 생성할 클래스의 이름은 Member 로 작성
		 */
		 Member mem1 = new Member();
		 mem1.num = 1;
		 mem1.name = "허남영";
		 mem1.addr = "봉천동";
		 
		 mem1.mem();
		 
		 Member mem2 = new Member();
		 mem2.num = 2;
		 mem2.name = "오영식";
		 mem2.addr = "상현동";
		 
		 mem2.mem();
		 
		 Member mem3 = new Member();
		 mem3.num = 3;
		 mem3.name = "김택근";
		 mem3.addr = "이의동";
		 
		 mem3.mem();
		 
		 // Member 객체의 메소드 호출하기
		 mem1.showInfo();
		 mem2.showInfo();
		 mem3.showInfo();
	}
}
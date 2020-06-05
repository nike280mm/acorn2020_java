package test.main;

import human.Blood;

public class MainClass10 {
	public static void main(String[] args) {
		// Blood 객체를 생성해서 참조값을 b1이라는 지역변수에 담기
		
		Blood b1 = new Blood("+ ", "O"); 
		
		String a = b1.getRh();
		String b = b1.getType();
		System.out.println("Rh"+a+b+"형 입니다");
		
		Blood b2 = new Blood("+ ", "A");
	}
}

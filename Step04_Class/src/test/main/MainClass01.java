package test.main;

import test.mypac.Bike;

public class MainClass01 {
	// run 했을 때 실행 순서가 시작되는 특별한 main() 메소드
	public static void main(String[] args) {
		// Bike 클래스를 이용해서 객체 생성하고 참조값을 지역 변수에 담기
		Bike bike1 = new Bike();
		// Bike 객체의 메소드 호출
		bike1.drive();
		// Car 객체의 필드에 값 대입
		bike1.name = "숑카";
		
		// 1. Car 클래스를 이용해서 객체를 생성하고 참조값을 car2라는 이름의 지역변수에 담기
		Bike bike2 = new Bike();
		// 2. 메소드를 호출해보기
		bike2.drive();
		// 3. name 이라는 필드에 차 이름을 담아 보세요
		bike2.name = "뿅카";
	}
}

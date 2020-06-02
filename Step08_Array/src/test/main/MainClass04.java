package test.main;

import test.mypac.Bike;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 1. Bike 객체를 담을 수 있는 방 3개짜리 배열 객체를 생성해서 참조값을
		 * 		bikes라는 지역 변수에 담아보십시오
		 * 2. 배열의 각각의 방 (0, 1, 2)에 Bike 객체를 생성해서 담아보기
		 * 3. 반복문 for를 이요해서 배열의 각각의 방에 있는 Bike객체의 ride()메소드를 호출하기
		 */
		
		Bike[] bikes = new Bike[3];
		
//		bikes[0] = new Bike();
//		bikes[1] = new Bike();
//		bikes[2] = new Bike();
//		
		for(int i= 0; i< bikes.length; i++) {
			bikes[i] = new Bike();
			bikes[i].ride();
		}
	}
}

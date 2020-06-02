package test.main;

import java.util.Random;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적 : 무작위 정수를 얻어내고 싶다
		 */
		
		// Random 객체를 생성해서 참조값을 지역변수에 담기
		Random ran = new Random();
		// 메소드를 호출하고 리턴되는 값을 지역 변수에 담기
		int r = ran.nextInt();
		// 콘솔창에 출력해보기
		System.out.println(r);
		
		/*
		 *	두번째 문제: 원하는 범위 내에서 정수값을 얻어내기
		 *	범위는 ? 1 ~ 45
		 *	값을 얻어내서 콘솔창에 출력
		 */
		
		int d = ran.nextInt(45)+1;
		System.out.println(d);
	}
}

package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		// SmartPhone 객체를 생성해서 Phone type 지역변수 p1에 담기
		Phone p1 = new SmartPhone();
		// p1에 들어있는 참조값을 이용해서 전화를 걸고 싶다면
		p1.call();
		// p1으로 이동중에 전화를 하고 싶다면
		HandPhone p2 = (HandPhone)p1;
		// 이렇게 요딴식으로다가
		p2.mobileCall();
		
		// p1에 들어있는 참조값을 이용해서 인터넷을 하고 싶다면
		SmartPhone p3 = (SmartPhone) p1;
		
		p3.doInternet();
		
		p1 = p2 = p3 ;
	}
}

package test.main;

import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		// SmartPhone type의 지역변수 p1을 만들 준비만 하고 만들어지지 않은 상태
		SmartPhone p1;
		// SmartPhone type의 지역변수 p2를 만들고 비워둔 상태
		SmartPhone p2 = null;
		// SmartPhone type의 지역변수 p3를 만들고 참조값을 넣어둔 상태
		SmartPhone p3 = new SmartPhone();
		
		// p1은 아직 만들어지지 않았기 때문에 문법이 성립하지 않는다
		//p1.call();
		
		// p2 는 비어있는 상태이기 때문에 NullPointerException이 발생한다
		//p2.call();
		
		// p3에는 참조값이 들어있으므로 정상적으로 사용 가능
		p3.call();
	}
}

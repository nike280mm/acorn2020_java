package test.main;

import test.mypac.Brand;
import test.mypac.Car;
import test.mypac.Coffee;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass05 {
	public static void main(String[] args) {

		MyObject maob1 = new MyObject();
		Car maca1 = new Car();
		Radio mara1 = new Radio();
		Speaker masp1 = new Speaker();
		Coffee maco1 = new Coffee();
		Brand mabr1 = new Brand();
		
		/*
		 * test.mypac 패키지에 다양한 모양의 메소드를 가지는
		 * 클래스를 정의하고
		 * 그 클래스를 이용해서 객체도 생성하고 메소드도 호출해보기
		 */
		maco1.extract();
		mabr1.nike(new Brand());		
	}
}

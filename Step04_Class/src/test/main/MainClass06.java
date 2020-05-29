package test.main;

import test.mypac.Bike;
import test.mypac.Box;
import test.mypac.Member;
import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		// new Box().
		System.out.println("main 메소드가 실행 됨");
		Member a = Box.mem; // null
		Rect b = Box.rect; // null
		Bike c = Box.bike; // 참조값이 들어있다
		c.drive(); // 메소드 호출 가능
		
		// 아래와 같이 사용할 수도 있다
		Box.bike.drive();
		
		//a.showInfo(); // a가 null이므로 NullPointerException 발생
		//b.getArea(); // b가 null이므로 NullPointerException 발생
	}
}

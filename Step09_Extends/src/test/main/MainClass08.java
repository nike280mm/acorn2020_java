package test.main;

import test.auto.Engine;
import test.auto.Man;
import test.auto.SUV;
import test.auto.SportsCar;
import test.auto.Truck;

public class MainClass08 {
	public static void main(String[] args) {
		// Truck 객체를 생성해서 .drive() .dump() 메소드를 호출하기
//		Truck t1 = new Truck(new Engine(), new Man());
//		
//		t1.drive();
//		t1.dump();
//		
//		// SportsCar 객체를 생성해서 .drive() 메소드를 호출하기
//		SportsCar sc = new SportsCar(new Engine(), new Man());
//		
//		sc.drive();
		
		SUV s1 = new SUV(new Engine(), new Man());
		
		s1.load();
		s1.drive();
		s1.doorLock();
	}
}

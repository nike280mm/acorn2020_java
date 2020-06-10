package test.main;

import test.auto.Car;

import test.auto.Engine;
import test.auto.Man;
import test.auto.SUV;

public class MainClass09 {
	public static void main(String[] args) {
		// Car 클래스를 상속받아서 만든 클래스로 객체를 생성해서
		// 아래의 useCar() 메소드를 호출하기
		SUV suv = new SUV(new Engine(), new Man());
		
		useCar(suv);
		MainClass09.useCar(suv);		
	}
	
	public static void useCar(Car car) {
		car.doorLock();	
	}
}

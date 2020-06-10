package test.main;

import java.util.ArrayList;
import java.util.List;
import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		// 1. Car type을 저장할 수 있는 ArrayList 객체를 생성해서
		// 참조값을 List 인터페이스 type 지역변수 cars에 담기
		
		List<Car> cars = new ArrayList<>();
		
		// 2. Car 객체 (3개)를 생성해서 List객체에 저장하기
		Car c1 = new Car("V90");
		Car c2 = new Car("3Series Touring");
		Car c3 = new Car("V40");
		
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		
		// 3. 반복문 for 문을 이용해서 List 객체에 저장된 모든 Car 객체의 drive() 메소드를 
		// 순서대로 호출하기
//		for(int i= 0; i<cars.size(); i++) {
//			Car tmp = cars.get(i);
//			System.out.println(tmp);
//		}
		for(Car tmp : cars) {
			tmp.drive();
		}
	}
}

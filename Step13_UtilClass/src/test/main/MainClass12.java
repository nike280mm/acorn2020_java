package test.main;

import java.util.HashSet;
import java.util.Set;

import test.mypac.Car;
/*
 * 	HashSet은 Set 인터페이스를 구현한 클래스이다
 * 
 * 	- 순서가 없다
 * 	- key 값도 없다
 * 	- 중복을 허용하지 않는다
 * 	- 어떤 data를 묶음(집합)으로 관리하고자 할 때 사용한다
 */
public class MainClass12 {
	public static void main(String[] args) {
		// 정수값을 저장할 수 있는 HashSet 객체
		Set<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(40);
		set1.add(40);
		// 문자열을 저장할 수 있는 HashSet 객체
		Set<String> set2 = new HashSet<>();
		set2.add("후에에에엥");
		set2.add("호에에에엥");
		set2.add("흐에에에엥");
		set2.add("흐에에에엥");
		
		// Car 객체를 저장할 수 있는 HashSet 객체
		Set<Car> set3 = new HashSet<>();
		set3.add(new Car("디아벨"));
		set3.add(new Car("CBR600RR"));
		set3.add(new Car("CBR600RR"));
		set3.add(new Car("CBR600RR"));
		Car car1 = new Car("뿌아아앙");
		set3.add(car1);
		set3.add(car1);
	}
}

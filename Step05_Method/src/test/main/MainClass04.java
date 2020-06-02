package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass04 {
 public static void main(String[] args) {
	
	MyObject obj1 = new MyObject();
	Car c1 = new Car();
	Radio r = new Radio();
	Speaker s = new Speaker();
	//useSome() 메소드를 호출하기	
	obj1.useSome("당근", c1);
	
	// doSome() 메소드를 호출하기
	obj1.doSome(r, s);
 }
}
package test.main;

<<<<<<< HEAD
import test.mypac.Bike;
import test.mypac.MyUtil;
import test.mypac.YourUtil;

public class MainClass03 {
	public static void main(String[] args) {
		// Car 객체를 생성해서 drive() 메소드 호출하기
		new Bike().drive();
		
		// Car 객체를 생성해서 참조값을 car1이라는 지역변수에 담기
		Bike bike1 = new Bike();
		// car1 안에 들어있는 참조값을 이용해서 drive() 메소드 호출하기
		bike1.drive();
		// Car 객체를 생성해서 참조값을 car2라는 지역변수에 담기
		Bike bike2 = new Bike();
		// car2 안에 들어있는 참조값을 이용해서 drive() 메소드 호출하기
		bike2.drive();
		
		// MyUtil 클래서의 send()라는 static 메소드 호출하기
		MyUtil.send();
		// YourUtil 클래스의 up()이라는 static 메소드 호출하기
		YourUtil.up();
	}
}
=======
import test.mypac.Car;
import test.mypac.MyUtil;
import test.mypac.YourUtil;

public class MainClass03 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 drive() 메소드 호출하기
		new Car().drive();
		
		//Car 객체를 생성해서 참조값을 car1 이라는 지역변수에 담기 
		Car car1=new Car();
		//car1 안에 들어 있는 참조값을 이용해서 drive() 메소드 호출하기 
		car1.drive();
		//Car 객체를 생성해서 참조값을 car2 라는 지역변수에 담기 
		Car car2=new Car();
		//car2 안에 들어 있는 참조값을 이용해서 drive() 메소드 호출하기 
		car2.drive();
		
		// MyUtil 클래스의 send() 라는 static 메소드 호출하기 
		MyUtil.send();
		// YourUtil 클래스의 up() 이라는 static 메소드 호출하기 
		YourUtil.up();
	}
}





>>>>>>> refs/remotes/upstream/master

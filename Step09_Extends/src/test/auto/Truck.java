package test.auto;

public class Truck extends Car {
	// Engine 객체를 생성자의 인자로 전달받는 메소드
	public Truck(Engine engine, Man man) {
		// 자식 생성자로 받은 객체를 부모 생성자에 전달해 주어야 부모 객체가 생성된다
		super(engine, man);
	}
	// 메소드
	public void dump() {
//		this.
		System.out.println("때려붓기");
	}
}

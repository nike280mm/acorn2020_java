package test.auto;

public class SUV extends Car{
	
	public SUV(Engine engine, Man man) {
		super(engine, man);
	}
	@Override
	public void drive() {
		super.drive();
	}
	public void load() {
		System.out.println("트렁크에 때려넣다");
	}
}

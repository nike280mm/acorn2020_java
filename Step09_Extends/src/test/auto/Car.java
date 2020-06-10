package test.auto;

public class Car {
	public Man man;
	// 필드
	protected Engine engine;
	
	// Engine 객체를 인자로 전달 받는생성자
	public Car(Engine engine, Man man) {
		// 필드에 저장하기
		this.engine = engine;
		this.man = man;
	}
	
	public void drive() {
		if(engine == null) {
			System.out.println("Engine 객체가 없어서 달릴 수 없음");
			return; // 메소드 끝내기
		}
		System.out.println("뿌아아아앙");
	}
	public void doorLock() {
		if(man == null) {
			System.out.println("사람이 타고 있어 Lock 불가");
		}else {
			System.out.println("문이 잠겼슴돠");
		}
	}
}

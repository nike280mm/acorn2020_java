package human;

public class Person {
	
	// 필드
	private Blood blood;
	
	// 생성자
	public Person(Blood blood) {
		this.blood = blood;		
	}
	// 메소드
	public void walk() {
		System.out.println("응용 포복");
	}
	public void study() {
		System.out.println("딴짓");
	}
	
}

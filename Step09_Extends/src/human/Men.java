package human;

public class Men extends Person{

	public Men(Blood blood) {
		super(blood); // 부모 생성자에 필요한 값을 전달한다
	}
	public void seeMovie() {
		System.out.println("영화를 봄");
	}
	@Override
	public void study() {
		super.study();
	}
	@Override
	public void walk() {
		super.walk();
	}
}

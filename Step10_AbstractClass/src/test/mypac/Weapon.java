package test.mypac;
/*
 * 	미완성된 않은 추상 메소드를 멤버로 가지고 있는 클래스는
 * 	abstract 예약어를 붙여서 정의한다 
 */
public abstract class Weapon {
	// 메소드
	public void prepare() {
		System.out.println("발포 준비");
	}
	// 미완성된 추상 메소드를 만들 때는 abstract 예약어를 붙여서 메소드를 정의한다
	public abstract void attack();
	
	public abstract void launch();
}

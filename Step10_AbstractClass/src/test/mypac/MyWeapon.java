package test.mypac;

public class MyWeapon extends Weapon{
<<<<<<< HEAD
	//상속받은 Weapon 클래스의 추상 메소드를 강제로 오버라이드 해야한다.
	@Override
	public void attack() {
		System.out.println("내가 알아서 공격해요!");
=======
	// 상속받은 Weapon 클래스의 추상 메소드를 강제로 오버라이드 한다
	@Override
	public void attack() {
		System.out.println("발사");
	}
	public void launch() {
		System.out.println("SLBM 발사");
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git
	}
}

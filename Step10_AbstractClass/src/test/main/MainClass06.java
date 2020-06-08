package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass06 {
	public static class YourWeapon extends MyWeapon{
		public void attack() {
			super.attack();
		}
		public void prepare() {
			super.prepare();
		}
	}
	
	public static void main(String[] args) {
		/*
		 *  useWeapon() 메소드를 호출하는 게 목적
		 *  호출하려고 보니 Weapon 추상 클래스 type 객체의 참조값이 필요하다
		 *  따라서 Weapon 추상 클래스를 상속받은 클래스를 파일로 만들어야 한다
		 *  근데 불금이다보니 만사가 귀찮아 클래스 파일을 따로 만들기 싫다
		 *  내부클래스(inner class)로 만들고 싶다
		 */
		Weapon w1 = new YourWeapon();
		useWeapon(w1);
		
		// local inner class 도 사용
		class OurWeapon extends MyWeapon{
			public void prepare() {
				super.prepare();
			}
			public void attack() {
				super.attack();
			}
			public void fly() {
				System.out.println("난다");
			}
			@Override
			public void launch() {
				System.out.println("SLBM 발사");
			}
		}
		Weapon y1 = new OurWeapon();
		useWeapon(y1);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.launch();
	}
}

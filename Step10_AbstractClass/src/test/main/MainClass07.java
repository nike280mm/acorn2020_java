package test.main;

import test.mypac.Weapon;

public class MainClass07 {
	
	// run 했을 때 실행순서가 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		/*
		 * 	Weapon 추상 클래스를 상속받은 익명의 local inner class의
		 * 	생성자를 호출해서 Weapon type의 참조값을 얻어내 지역변수 w1에 담기 
		 */
		Weapon w1 = new Weapon() {

			@Override
			public void attack() {
				System.out.println("아무나 공격");
			}

			@Override
			public void launch() {
			}
		};
		
		Weapon w2 = new Weapon() {
			
			@Override
			public void launch() {
			}
			
			@Override
			public void attack() {
				System.out.println("공중 공격");
			}
		};
		
		useWeapon(w1);
		useWeapon(w2);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.launch();
	}
}

package test.main;

import test.mypac.Weapon;

public class MainClass08 {
<<<<<<< HEAD
	//클래스의 필드에 Weapon type 의 참조값 넣어두기
	static Weapon w1=new Weapon() {	// anonymous inner class 
		@Override
		public void attack() {
			System.out.println("수중 공격을 해요");
		}
	};
	
	public static void main(String[] args) {
		//필드에 저장된 Weapon type 의 참조값을 이용해서 useWeapon() 메소드 호출하기
		useWeapon(w1);
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}






=======
	// 클래스의 필드에 Weapon type의 참조값 넣어두기
	static Weapon w1 = new Weapon() {// anonymous inner class
		
		@Override
		public void launch() {
		}
		
		@Override
		public void attack() {
			System.out.println("수중 공격");
		}
	};
	
	public static void main(String[] args) {
		// 필드에 저장된 Weapon type의 참조값을 이용해서 useWeapon() 메소드 호출하기
		useWeapon(w1);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.launch();
	}
}
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git

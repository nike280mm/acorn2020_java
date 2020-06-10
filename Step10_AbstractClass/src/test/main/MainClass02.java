package test.main;

import test.mypac.Gun;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		// 직접 클래스를 만들고 객체를 생성해서 
		// 아래의 useWeapon() 메소드를 호출하기
		
		Weapon gun = new Gun();
		
		useWeapon(gun);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}

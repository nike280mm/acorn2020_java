package test.mypac;

public class Marine {
	// 공격력을 저장하고 있는 static 필드
	public static int attackPower = 6;
	// 에너지를 저장하고 있는 non static 필드
	public int energy = 40;
	
	// 움짐ㄱ이는 메소드
	public void move() {
		System.out.println("마린이 나대요");
	}
	// 공격하는 메소드
	public void attack() {
		System.out.println(Marine.attackPower+" 의 공격력으로 공격함");
	}
	// 현재 에너지를 출력하는 메소드
	public void showEnergy() {
		System.out.println("현재 에너지: "+this.energy);
	}
}
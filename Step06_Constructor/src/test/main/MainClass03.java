package test.main;

import test.mypac.Computer;
import test.mypac.Cpu;

public class MainClass03 {
	public static void main(String[] args) {
		// Computer 객체를 생성해서 참조값을 c1이라는 이름의 지역 변수에 담기
		
		Computer c1 = new Computer(new Cpu());
		
		// c1에 들어있는 참조값을 이용해서 .doGame() 메소드를 호출하기
		c1.doGame();
	}
}

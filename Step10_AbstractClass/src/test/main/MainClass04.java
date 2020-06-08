package test.main;
/*
<<<<<<< HEAD
 * 	클래스 안에 만든 클래스 : inner class
 * 	메소드 안에 만든 클래스 : local inner class
 */
public class MainClass04 {
	public static void main(String[] args) {
		// 메소드 안에서도 클래스 정의 가능?
		class Nam{
			public void say() {
				System.out.println("I'm Nam !");
			}
		}
		// 메소드 안에 정의한 클래스를 이용해서 객체를 생성하고 참조값을 지역변수에 담기
		Nam n = new Nam();
		n.say();
	}
}

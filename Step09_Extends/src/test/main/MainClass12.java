package test.main;

<<<<<<< HEAD
import test.human.Blood;
import test.human.Woman;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 *  프로그래밍의 목적: 독서를 하고 싶다.
		 *  독서하는 프로그래밍을 해 보세요.
		 */
		Woman w1=new Woman(new Blood("-", "B"));
		w1.reading();
	}
}






=======
import human.Blood;
import human.Women;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * 	프로그래밍의 목적 : 독서를 하고 싶다
		 * 	독서하는 프로그래밍을 해보기
		 */
		
		// pattern 1
		Women wo = new Women(new Blood("+", "AB"));
		
		wo.reading();
		
		// pattern 2
		Blood b1 = new Blood("+", "AB");
		Women wo2 = new Women(b1);
		wo2.reading();
		
		// pattern 3
		new Women(new Blood("+", "AB")).reading();
	}
}
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git

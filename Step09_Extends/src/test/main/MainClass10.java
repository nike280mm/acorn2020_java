package test.main;

<<<<<<< HEAD
import test.human.Blood;

public class MainClass10 {
	public static void main(String[] args) {
		//Blood 객체를 생성해서 참조값을 b1 이라는 지역 변수에 담아 보세요.
		Blood b1=new Blood("+", "O"); // Rh+ O 형 혈액형을 의미
		Blood b2=new Blood("+", "A"); // Rh+ A 형 혈액형을 의미 
		
		// Blood 객체의 getter 메소드 사용해 보기 
		String result1=b1.getRh(); // "+"
		String result2=b1.getType(); // "O"
		
		String result3=b2.getRh(); // "+"
		String result4=b2.getType(); // "A" 
	}
}






=======
import human.Blood;

public class MainClass10 {
	public static void main(String[] args) {
		// Blood 객체를 생성해서 참조값을 b1이라는 지역변수에 담기
		
		Blood b1 = new Blood("+ ", "O"); 
		
		String a = b1.getRh();
		String b = b1.getType();
		System.out.println("Rh"+a+b+"형 입니다");
		
		Blood b2 = new Blood("+ ", "A");
	}
}
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git

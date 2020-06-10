package test.main;

public class MainClass05 {
<<<<<<< HEAD
	//필드 
	public String myName="김구라";
	public static String yourName="원숭이";
	
	public static void main(String[] args) {
		//static 메소드 안에서 this 는 의미도 없고 사용불가
		//System.out.println(this.myName);
		
		//myName 이라는 필드는 non static 이므로 클래스명. 으로 접근 불가
		//System.out.println(MainClass05.myName);
		
		//myName 은 non static 필드임으로 참조값으로 접근 가능  
		System.out.println(new MainClass05().myName);
		
		// yourName 이라는 필드는 static 이므로 클래스명. 으로 접근 가능
		System.out.println(MainClass05.yourName);
		
		// yourName 과 main() 메소드는 동일 클래스 내부에 있기 때문에 클래스명 생략 가능
		System.out.println(yourName);
		
		//static 메소드 안에서 this 는 의미도 없고 사용불가 
		//System.out.println(this.yourName);
	}
}






=======
	// 필드
	public String myName = "남영";
	public static String yourName = "ㅇㅇ";

	public static void main(String[] args) {
		// statis 메소드 안에서 this는 의미도 없고 사용 불가
		//System.out.println(this.myName);
		
		// myName이라는 필드는 non static 이므로 클래스명 . 으로 접근 불가
		//System.out.println(MainClass05.myName);
		
		// myName은 non static 필드임으로 참조값으로 접근 가능
		//System.out.println(new MainClass05().myName);
		
		// yourName이라는 필드는 static이므로 클래스명 . 으로 접근 가능
		System.out.println(MainClass05.yourName);
		
		// yourName과 main() 메소드는 동일 클래스 내부에 있기 때문에 클래스명 생략 가능
		System.out.println(yourName);
		
		// static 메소드 안에서 this는 의미도 없고 사용 불가
		//System.out.println(this.yourName);
	}	
}
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git

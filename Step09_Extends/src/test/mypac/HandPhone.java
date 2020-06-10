package test.mypac;

// Phone 클래스를 상속받은 handPhone 클래스
public class HandPhone extends Phone {
	// 생성자
	public HandPhone() {
		System.out.println("HandPhone() 생성자 호출됨");
	}
	// 메소드
	public void mobileCall() {
		System.out.println("통신보안");
	}
	public void takePicture() {
		System.out.println("찰칵");
	}
}

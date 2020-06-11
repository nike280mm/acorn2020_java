package test.mypac;

public class MyUtil {
	public static void draw() {
		System.out.println("5초 동안 그림을 그린다");
		// 발생하는 Exception을 메소드 내에서 직접 처리한 경우
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("그림 콤풀리트");
	}
	
	public static void send() throws InterruptedException {
		System.out.println("5초 동안 전송한다");
		Thread.sleep(5000);
		System.out.println("전송완료");
	}
}

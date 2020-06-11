package test.mypac;

public class SleepyException extends RuntimeException{
	// 예외 메세지를 생성자의 인자로 전달 받아서
	public SleepyException(String msg) {
		super(msg); // 부모 생성자에 전달
	}
}

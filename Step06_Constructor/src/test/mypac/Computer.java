package test.mypac;

public class Computer {
	// 필드
	public Cpu cpu;
<<<<<<< HEAD
	//기본 생성자(인자로 아무것도 전달 받지 않는 생성자)
	public Computer() {
		System.out.println("기본 생성자가 호출되었습니다.");
	}
	//생성자
=======

	// 기본 생성자(인자로 아무것도 전달받지 않는 생성자)
	public Computer() {
		System.out.println("기본 생성자가 호출됨");
	}
	
	// 생성자
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git
	public Computer(Cpu cpu) {
		this.cpu = cpu;
	}
	// 메소드
	public void doGame() {
		if(this.cpu == null) {
			System.out.println("Cpu 뻑남");
			return; // 메소드 끝내기			
		}
		System.out.println("Game을 시작하지");
	}
}
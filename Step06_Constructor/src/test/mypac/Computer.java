package test.mypac;

public class Computer {
	// 필드
	public Cpu cpu;
	
	// 생성자
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

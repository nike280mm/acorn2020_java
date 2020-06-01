package test.mypac;

public class Member {
<<<<<<< HEAD
	// non static 필드 정의
	public int num;
	public String name;
	public String addr;
	
	// non static 메소드 정의
	public void mem() {
		System.out.println(num +", "+ name +", "+ addr);
	}
	// 사각형의 면적을 리턴해주는 non static 메소드
	public void showInfo() {
		System.out.println(this.num+" | "+this.name+" | "+this.addr);
	}
}
=======
	//non static 필드 정의하기
	public int num;
	public String name;
	public String addr;
	
	//non static 메소드 정의하기
	public void showInfo() {
		System.out.println(this.num+" | "+this.name+" | "+this.addr);
	}
}






>>>>>>> refs/remotes/upstream/master

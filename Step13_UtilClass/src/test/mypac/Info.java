package test.mypac;

public class Info {
	private int num;
	private String name;
	private String addr;
	
	public Info() {}
	
	public Info(int num, String name, String addr) {
		this.num = num;
		this.name = name;
		this.addr = addr;
	};
	
	public void print() {
		System.out.println(num +" | "+ name +" | "+ addr);
	}
}

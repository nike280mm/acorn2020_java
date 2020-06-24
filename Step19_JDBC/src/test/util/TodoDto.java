package test.util;

public class TodoDto {
	// 메모할 정보를 담을 필드
	private int num;
	private String todo;
	private String till;
	
	// default 생성자
	public TodoDto() {}

	// 인자로 필드에 저장할 값을 전달받는 생성자
	public TodoDto(int num, String todo, String till) {
		super();
		this.num = num;
		this.todo = todo;
		this.till = till;
	}
	// 필드의 접근 메소드 getter, setter 메소드

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getTill() {
		return till = till;
	}

	public void settill(String till) {
		this.till = till;
	}
}

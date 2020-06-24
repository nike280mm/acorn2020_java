package test.util;

public class MemoDto {
	// 메모할 정보를 담을 필드
	private int num;
	private String content;
	private String regdate;
	
	// default 생성자
	public MemoDto() {}

	// 인자로 필드에 저장할 값을 전달받는 생성자
	public MemoDto(int num, String content, String regdate) {
		super();
		this.num = num;
		this.content = content;
		this.regdate = regdate;
	}
	// 필드의 접근 메소드 getter, setter 메소드

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate = regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}

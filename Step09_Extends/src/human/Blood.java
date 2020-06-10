package human;

public class Blood {
	
	// 필드
	private String rh;
	private String type;
	
	// 생성자
	public Blood(String rh, String type) {
		this.rh = rh;
		this.type = type;
	}
	/*
	 *  필드를 선언하고 나서 get을 타이핑 후 ctrl + space 키를 누르면
	 *  이클립스가 getter 메소드를 자동으로 만들어 줄 준비를 한다
	 */
	// 필드에 저장된 rh를 리턴해주는 getter 메소드
	public String getRh() {
		return rh;
	}
	// 필드에 저장된 type을 리턴해주는 getter 메소드
	public String getType() {
		return type;
	}
}

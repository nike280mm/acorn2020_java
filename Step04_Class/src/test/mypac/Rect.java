package test.mypac;

// 사각형의 정보를 담을 수 있는 Rect 클래스
public class Rect {
	// non static 필드
	public int width;
	public int height;
	
	// 사각형의 면적을 리턴해주는 non static 메소드
	public int getArea() {
		int area = this.width * this.height;
		return area;
	}
}

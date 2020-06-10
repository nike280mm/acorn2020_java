package test.main;

import test.mypac.Rect;

public class MainClass05 {
	public static void main(String[] args) {
		// 1. Rect 객체를 담을 수 있는 방 3개 배열객체를 생성해서 참조값을
		//		rects라는 이름의 지역변수에 담아보기
		
		// 2. 배열에 Rect 객체 3개를 순서대로 담기
		
		// 3. 반복문 for문을 이용해서 각각 4각형의 면적을 콘솔창에 출력하기
		
		Rect[] rects = new Rect[3];
		
//		rects[0] = new Rect(100, 100);		
//		rects[1] = new Rect(200, 200);		
//		rects[2] = new Rect(300, 300);
		
		for(int i= 0; i< rects.length; i++) {
			rects[i] = new Rect((i+1)*100, (i+1)*100);
			int a = rects[i].getArea();
			System.out.println(a);
		}
	}
}

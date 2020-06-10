package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass03 {
	public static void main(String[] args) {
		//String type  을 저장할 ArrayList 객체 생성하고 
		//참조값을 List 인터페이스 type 지역변수 msgs 에 담기
		
		List<String> msgs = new ArrayList<>();
		
		msgs.add("김구라");
		msgs.add("해골");
		msgs.add("원숭이");
		msgs.add("주뎅이");
		msgs.add("덩어리");
		
		// List 객체에 담긴 문자열을 for 문을 이용해서 순서대로 콘솔창에 출력하기
		
		for(int i= 0; i< msgs.size(); i++) {
			String tmp = msgs.get(i);
			System.out.println(tmp);
		}
		
		System.out.println("확장 for 문");
		for(String tmp : msgs) {
			System.out.println(tmp);
		}
	}
}

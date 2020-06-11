package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<String, String>();
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		/*
		 * 	검색할 단어를 입력하세요: house
		 * 
		 * 	house의 뜻은 집 입니다
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 단어를 입력하세요: ");
		String m = scan.nextLine();
		String result = dic.get(m);
		boolean isExist = dic.containsKey(m);
		
		if(isExist == true) {
			System.out.println(m + "의 뜻은 " + result + "입니다.");
		} else {
			System.out.println("장난 나랑 지금 하냐 ?");
		}
	}
}

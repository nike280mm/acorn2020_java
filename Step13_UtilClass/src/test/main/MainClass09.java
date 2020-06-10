package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 	3명의  회원정보(번호, 이름, 주소)를 HashMap 객체에 담고
		 * 	HashMap 객체의 참조값을 ArrayList 객체에 순서대로 담기
		 */
		Map<String, Object> li1 = new HashMap<>();
		li1.put("num", 1);
		li1.put("name", "김구라");
		li1.put("addr", "노량진");
		
		Map<String, Object> li2 = new HashMap<>();
		li2.put("num", 2);
		li2.put("name", "해골");
		li2.put("addr", "행신동");

		Map<String, Object> li3 = new HashMap<>();
		li3.put("num", 3);
		li3.put("name", "원숭이");
		li3.put("addr", "상도동");
		
		List<Map<String, Object>> mem = new ArrayList<>();
		
		mem.add(li1);
		mem.add(li2);
		mem.add(li3);
		
		for(Map<String, Object> tmp : mem) {
			int num = (int)tmp.get("num");
			String name = (String)tmp.get("name");
			String addr = (String)tmp.get("addr");
			System.out.println(num + " | " + name + " | " + addr);
		}
		
		// 참조 연습
		List<Map<String, Object>> a = mem;
		Map<String, Object> b = mem.get(0);
		Object c = mem.get(0).get("num");
		Object d = mem.get(0).get("name");
		Object e = mem.get(0).get("addr");
		int f = (int)mem.get(0).get("num");
		String g = (String)mem.get(0).get("name");
		String h = (String)mem.get(0).get("addr");
		int i = ((String)mem.get(0).get("addr")).length();
	}
}

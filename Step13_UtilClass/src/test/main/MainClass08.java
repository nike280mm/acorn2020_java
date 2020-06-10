package test.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * 	HashMap<key 값의 type, value 값의 type>
 */
public class MainClass08 {
	public static void main(String[] args) {
	Map<String, Object> map = new HashMap<>();
	map.put("num", 1);
	map.put("name", "김구라");
	map.put("addr", "노량진");
	/*
	 *  value 의 Generic 클래스가 Object로 지정돼 있기 때문에
	 *  리턴되는 Object type은 원래 type으로 casting 해야 한다
	 */
	int num = (int)map.get("num");
	String name = (String)map.get("name");
	String addr = (String)map.get("addr");
	System.out.println(num+" | "+name+" | "+addr);
	}
}

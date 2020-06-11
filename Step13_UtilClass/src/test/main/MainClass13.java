package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainClass13 {
	public static void main(String[] args) {
		// 정수를 담을 수 있는 HashSet 객체를 생성하고 참조값을 Set type 지역 변수에 담기
		Set<Integer> nums = new HashSet<>();
		
		// 0 ~ 9 정수를 for문을 이용해서 담기
		for(int i = 0; i< 10; i++) {
			nums.add(i);
		}
		
		// Set에 저장된 item의 갯수?
		int size = nums.size();
		
		// Set에 저장된 item을 모두 불러오기
		Iterator<Integer> it = nums.iterator();
		// it.hasNext()는 커서 다음에 읽어낼 데이터가 있는지 확인하면서
		// 있으면 true, 없으면 false를 리턴한다
		while(it.hasNext()) {
			// it.next()는 커서를 한 칸 움직여서 커서가 위치한 곳의 데이터를 읽어온다
			int tmp = it.next();
			System.out.println(tmp);
		}
	}
}

package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Info;

public class MainClass05 {
	public static void main(String[] args) {
		// Info  클래스로 객체를 생성해서 참조값을 i1이라는 지역 변수에 담기
		Info i1 = new Info(1, "김구라", "노량진");
		Info i2 = new Info(2, "해골", "행신동");
		
		List<Info> mem = new ArrayList<>();
		mem.add(i1);
		mem.add(i2);
		
		for(Info tmp : mem) {
			tmp.print();
		}
	}
}

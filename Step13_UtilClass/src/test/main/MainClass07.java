package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass07 {
	public static void main(String[] args) {
		// default 생성자를 이용해서 객체를 생성한 경우
		MemberDto m1 = new MemberDto();
		m1.setNum(1);
		m1.setName("김구라");
		m1.setAddr("노량진");
		
		// 인자로 필드에 저장할 생성자를 이용해서 객체를 생성한 경우
		MemberDto m2 = new MemberDto(2, "해골", "행신동");

		// 위에서 생성한 객체의 참조값을 List 객체에 담기
		List<MemberDto> dto1 = new ArrayList<>();
		
		dto1.add(m1);
		dto1.add(m2);
		
		/*
		 * 	for문을 이용해서 List 객체에 담긴 MemberDto 객체를 순서대로 참조하여
		 * 	아래와 같은 형식으로 출력하기
		 * 
		 *	1 | 김구라 | 노량진
		 */
		for(MemberDto tmp : dto1) {
			String list = tmp.getNum() + " | "+tmp.getName()+" | "+tmp.getAddr()+" | ";
			System.out.println(list);
		}
		
		// 참조 테스트
		List<MemberDto> a = dto1;
		
		MemberDto b = dto1.get(0);
		
		int c = dto1.get(0).getNum();
		
		String d = dto1.get(0).getName();
		
		String e = dto1.get(0).getAddr();
		
		int f = dto1.get(0).getName().length();
		
		dto1.get(0).getName().length();
	}
}

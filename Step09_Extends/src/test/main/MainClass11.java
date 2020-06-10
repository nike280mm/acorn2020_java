package test.main;

import human.Blood;
import human.Men;
import human.Women;
import test.mypac.Person;

public class MainClass11 {
	public static void main(String[] args) {
		/*
		 * 	프로그래밍의 목적 : 영화를 보고 싶다
		 * 	영화를 보는 프로그래밍의 목적을 달성하기
		 */

		// pattern 1 
		Men ny = new Men(new Blood("+", "O"));
		
		ny.seeMovie();
		
		// pattern 2
		Blood b1 = new Blood("+", "B");
		Men men2 = new Men(b1);
		men2.seeMovie();
		
		// pattern 3
		new Men(new Blood("-", "B")).seeMovie();
		
		
		Women hn = new Women(new Blood("+", "O"));
		
		hn.reading();
	}
}

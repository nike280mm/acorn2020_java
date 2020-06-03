package test.main;

import java.util.Random;

/*
 * 	1.
 * 	cherry, apple, banana, melon, 7
 * 
 * 	5개의 문자열 중에서 하나가 랜덤하게 출력되게 해보기
 * 
 * 	2. 5개의 문자열 주에서 3개가 한 줄에 한 번에 랜덤하게 출력되게 해보기
 */
public class MainClass08 {
	public static void main(String[] args) {
		Random ran = new Random();
		String[] img = {"cherry", "apple", "banana", "melon", "7"};
		String[] items = new String[3];
		
		for(int i= 0; i< 3; i++) {
			int rullno = ran.nextInt(5);
			items[i] = img[rullno];
		}
		
		System.out.println(items[0]+" | "+items[1]+" | "+items[2]);			
	}
}
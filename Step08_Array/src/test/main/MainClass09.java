package test.main;

import java.util.Random;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 	1.
		 * 	cherry, apple, banana, melon, 7
		 * 
		 * 	5개의 문자열 중에서 하나가 랜덤하게 출력되게 해보기
		 * 
		 * 	2. 5개의 문자열 주에서 3개가 한 줄에 한 번에 랜덤하게 출력되게 해보기
		 * 
		 * 	cherry | cherry | cherry
		 * 	10점 입니다
		 * 
		 * 	apple | apple | apple
		 * 	20점 입니다
		 * 
		 * 	banana
		 * 	30점
		 * 
		 * 	7
		 * 	1000점
		 * 
		 * 	apple | cherry | apple
		 */
		
		Random ran = new Random();
		
		String[] img = {"cherry", "apple", "banana", "melon", "7"};
		
		int[] points = {10, 20, 30, 40, 1000};

		int[] nums = new int[3];
		
		String[] items = new String[3];
				
		for(int i= 0; i< 3; i++) {
			int roullno = ran.nextInt(5);
			items[i] = img[roullno];
			nums[i] = roullno;
		}
		
		String a = items[0]+" | "+items[1]+" | "+items[2];
		
		if(items[0] == items[1] && items[1] == items[2]) {
			int point = points[nums[0]];
			System.out.println(a);
			System.out.println(point);
		}else {
			System.out.println(a);
			System.out.println("0점 입니다 !");
		}
	}
}

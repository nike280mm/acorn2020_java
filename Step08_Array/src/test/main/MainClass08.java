package test.main;

import java.util.Random;

<<<<<<< HEAD
/*   
 *   hint 
 *   
 *   String[] items={"cherry", "apple", "banana", "melon", "7"};
 *  
 *   1. cherry, apple, banana, melon, 7
 *      5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
 *   
 *   2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
 *      예)  cherry | apple | cherry
 *           7 | apple | melon
 *           7 | 7 | 7
 *      
 */
public class MainClass08 {
	public static void main(String[] args) {
		//렌덤하게 출력할 문자열을 미리 배열에 담아 놓는다. 
		String[] items={"cherry", "apple", "banana", "melon", "7"};
		//렌덤한 숫자를 얻어내기 위한 객체
		Random ran=new Random();
		//0~4 사이의 렌덤한 정수 얻어내기
		int ranNum=ran.nextInt(5);
		
		System.out.println(items[ranNum]);
	}
}








=======
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
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git

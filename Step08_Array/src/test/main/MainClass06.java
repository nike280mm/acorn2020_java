package test.main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/* 1.
		 *  Scanner 객체를 이용해서 문자열을 5번 입력 받는다
		 *  입력받은 문자열은 차례대로 배열에 저장돼야 한다
		 *  모두 다 입력받은 후 for문을 이용해서 배열에 저장된
		 *  모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성한다
		 */
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("문자열을 입력하세요: ");
//		String str1 = scan.nextLine();
//		String str2 = scan.nextLine();
//		String str3 = scan.nextLine();
//		String str4 = scan.nextLine();
//		String str5 = scan.nextLine();
//				
//		add[0] = str1;
//		add[1] = str2;
//		add[2] = str3;
//		add[3] = str4;
//		add[4] = str5;
		
		Scanner scan = new Scanner(System.in);
		String[] add = new String[5];
		
		for(int i= 0; i< add.length; i++) {
			
			System.out.println("문자 입력: ");
			
			String str = scan.nextLine();
			
			add[i] = str;	
		}
		for(int i= 0; i< add.length; i++) {
			
			System.out.println(add[i]);			
		}
		
		/* 2.
		 * Random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내서
		 * 배열에 저장
		 * 모두다 저장되면 for문을 이용해서 배열에 저장된 모든 로또번호를
		 * 콘솔창에 순서대로 출력하는 코드를 작성
		 */
		
		int[] nums = new int[6];		
				
		for(int i= 0; i< nums.length; i++) {
			
			Random ran = new Random();
			
			int r = ran.nextInt(10)+(i*7);
			
			if(i>= 1 && nums[i-1] >= r ) {
			
				r = r + 3;
			} 
			nums[i] = r + 1;			
		}
		for(int i= 0; i< nums.length; i++) {
			
			System.out.println(nums[i]);
		}
	}
}

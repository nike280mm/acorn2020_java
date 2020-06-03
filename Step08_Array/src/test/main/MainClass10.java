package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 외형상 무한루프
		while(true) {
			System.out.print("종료(q) 계속(Enter): ");
			String str = scan.nextLine();
			if(str.equals("q")) {// 무한루프 탈출 조건
				break; // while문 탈출
			}
			System.out.println("무언가 작업 중...");
			
			MainClass10.doGame();
		}
		System.out.println("main 메소드가 종료됩니다");
	}
	
	public static void doGame() {
		
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

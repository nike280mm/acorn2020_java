package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass12 {
	public static void main(String[] args) {
		String[] items = {"가위", "바위", "보",};
		Scanner scan = new Scanner(System.in);
		Random	ran = new Random();
		System.out.println("가위(s) 바위(r) 보(p):");
		
		String userInput = scan.nextLine();
		
		int me = 0;
		if(userInput.equals("s")) {
			me = 0;
		}else if(userInput.contentEquals("r")) {
			me = 1;
		}else if(userInput.contentEquals("p")) {
			me = 2;
		}
		
		int com = ran.nextInt(3);
		
		String result = null;
		// 4.승패 판단
		if((me == 0 && com == 2) || (me == 1 && com == 0) || (me == 2 && com == 1)){// 내가 이기능 경우
			result = "win";
		}else if(me == com) {// 비기는 경우
			result = "draw";
		}else {
			result = "lose";
		}
		System.out.println("나: "+items[me] + " vs 컴: "+items[com]);
		System.out.println(result);
	}
}

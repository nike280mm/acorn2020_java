package test.main;

<<<<<<< HEAD
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainClass12 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		//외형상 무한 루프
		while(true) {
			System.out.print("종료(q) 계속(Enter):");
			String str=scan.nextLine();
			if(str.equals("q")) {//무한 루프 탈출 조건
				break; //while  문 탈출
			}
			//이전 예제에서 작업한 내용을 static 메소드에 이동 시키고 해당 메소드 호출하기 
			MainClass12.doGame();
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
	
	public static void doGame() {
		//렌덤하게 출력할 문자열을 미리 배열에 담아 놓는다. 
		String[] items={"cherry", "apple", "banana", "melon", "7"};
		//렌덤한 숫자를 얻어내기 위한 객체
		Random ran=new Random();
		//렌덤하게 얻어낸 3개의 정수를 저장할 배열
		int[] nums=new int[3];
		//0~4 사이의 렌덤한 정수 3개 얻어내기
		for(int i=0;i<3;i++) {
			//렌덤한 정수를 얻어내서 
			int ranNum=ran.nextInt(5);
			nums[i]=ranNum; //배열에 저장한다 
		}
		
		for(int i=0;i<nums.length; i++) {
			try {
				//실행의 흐름(스레드)을  1초 잡아 놓기  
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//.print() 메소드를 이용해서 개행 기호를 출력하지 않는다. 
			System.out.print("|\t"+items[nums[i]]+"\t|");
		}
		
		//개행 두번 하기
		System.out.println();
		System.out.println();
		
		//부여할 점수를 미리 배열에 담아 놓는다. 
		int[] points= {10, 20, 30, 40, 1000};
		//nums 배열에 있는 3개의 숫자가 모두 같은지 비교해 본다.
		if(nums[0]==nums[1] && nums[1]==nums[2]) {//3개가 모두 같은 경우
			//점수를 부여해야 한다 . 몇점이지?
			//nums  배열에 있는 숫자 3개가 다 같으므로 아무거나 하나를 읽어와서
			//점수를 얻어낸다
			int point=points[nums[0]];
			System.out.println(point+"점 입니다.");
		}else {//하나라도 다른 경우
			// 0 점
			System.out.println("0점 입니다.");
		}		
	}
}








=======
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
>>>>>>> branch 'study' of https://github.com/nike280mm/acorn2020_java.git

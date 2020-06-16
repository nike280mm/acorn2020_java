package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 *	Scanner 객체를 이용해서 문자열 한 줄을 입력받은 다음
		 * 	c:/acorn2020/myFolder/quiz.txt 파일을 만들어서
		 * 	해당 파일에 저장하기
		 */
		File quizFile = new File("c:/acorn2020/myFolder/quiz.txt");
		System.out.println("입력할 문장: ");
		Scanner scan = new Scanner(System.in);
		String txt = scan.nextLine();
		try {
			boolean isExist = quizFile.exists();
			if(!isExist) {
				quizFile.createNewFile();
			}
			// new FileWriter(File 객체, append 모드 여부);
			FileWriter fw = new FileWriter(quizFile, true);
			// fw.write(txt);
			fw.append(txt);
			fw.append("\r\n");
//			fw.flush();
			fw.close(); // 자동 flush 된다
			System.out.println("문자열을 파일에 저장했슴돠");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

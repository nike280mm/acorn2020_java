package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass09 {
	public static void main(String[] args) {
		File f1 = new File("c:/acorn2020/myfolder/NY.txt");
		try {
			f1.createNewFile();
			System.out.println("NY.txt 파일을 만들었음");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

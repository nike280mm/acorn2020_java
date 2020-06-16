package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass16 {
	public static void main(String[] args) {
		// 필요한 참조값을 담을 지역변수를 미리 만든다
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 파일에서 byte를 읽어낼 객체
			fis = new FileInputStream("c:/acorn2020/myFolder/1.jpg");
			// 읽어낸 byte를 출력할 객체
			fos = new FileOutputStream("c:/acorn2020/myFolder/copied.jpg");
			// 반복문 돌면서 읽어내기
			while(true) {
				// 1byte씩 읽어들인다
				int data = fis.read();
				if(data == -1) {
					break;
				}
				// 읽은 1byte 출력
				fos.write(data);
				fos.flush();
			}
			System.out.println("끝");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null)fis.close();
				if(fos != null)fos.close();
			} catch (IOException ie) {}
		}
	}
}

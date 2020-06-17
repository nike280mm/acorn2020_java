package example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket = null;
		try {
			// 5000번 통신 port를 열고 클라이언트의 접속을 기다린다
			serverSocket = new ServerSocket(5000);
			System.out.println("클라이언트의 Socket 연결 요청을 대기");
			/*
			 * 	accept() 메소드는 클라이언트가 실제 접속을 할 때까지 리턴하지 않고
			 * 	블록킹 되는 메소드이다
			 * 	클라이언트가 접속을 해오면 Socket 객체의 참조값을 반환하면서 리턴된다
			 */
			while(true) {
				System.out.println("클라이언트의 Socket 연결 요청을 대기");
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트가 접속했습니다");
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 IP: " + clientIp);
				socket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null)serverSocket.close();
				
			}catch (Exception e) {}
		}
	}
}

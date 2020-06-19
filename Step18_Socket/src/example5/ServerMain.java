package example5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerMain {
	// static 필드
	static List<ServerThread> threadList = new ArrayList<>();
	
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket = null;
		try {
			// 5000번 통신 port를 열고 클라이언트의 접속을 기다린다
			serverSocket = new ServerSocket(5000);
			while(true) {
				// 클라이언트의 소켓 접속을 기다린다
				Socket socket = serverSocket.accept();
				// 방금 접속한 클라이언트를 응대할 스레드를 시작한다
				ServerThread thread = new ServerThread(socket);
				thread.start();
				// 생성하고 시작한 스레드의 참조값을 List에 저장하기
				threadList.add(thread);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null)serverSocket.close();
				
			}catch (Exception e) {}
		}
	}
	// 내부 클래스로 스레드 객체를 생성할 클래스를 정의한다
	// static main() 메소드에서 클래스를 사용하기 위해 static 예약어를 붙여서 정의한다
	public static class ServerThread extends Thread{
		// 필드
		Socket socket;
		// 클라이언트에게 출력할 문자열을 
		BufferedWriter bw;
		// 클라이언트의 대화명을 저장할 필드
		String chatName;
		
		// 생성자의 인자로 Socket 객체를 전달 받도록 한다
		public ServerThread(Socket socket) {
			// 생성자의 인자로 전달 받은 socket 객체의 참조값을 필드에 저장한다
			this.socket = socket;
		}
		// 인자로 전단될 문자열을 출력하는 메소드
		public void sendMessage(String msg) throws IOException {
			// 반복문 돌면서 모든 스레드의 BufferedWriter 객체를 이용해서
			// 문자
			for(ServerThread tmp : threadList) {
				tmp.bw.write(msg);
				tmp.bw.newLine();
				tmp.bw.flush();
			}
		}
		// 참여자 목록을 얻어내서 Client에게 출력해주는 메소드
		public void sendChatNameList() {
			JSONObject jsonObj = new JSONObject();
			JSONArray jsonArr = new JSONArray();
			// 스레드 리스트에서 대화명을 순서대로 참조해서 JSONArray 객체에 순서대로 넣기
			for(int i= 0; i<threadList.size(); i++) {
				ServerThread tmp = threadList.get(i);
				jsonArr.put(i, tmp.chatName);
			}
				
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonArr);
			
			try {
				sendMessage(jsonObj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 새로운 작업 단위가 시작되는 run() 메소드
		@Override
		public void run() {
			try {
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 IP: " + clientIp);
				// 클라이언트로부터 읽어들일 (Input) 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				// 클라이언트에게 출력할 수 있는 객체
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				while(true) {
					// 클라이언트가 전송하는 문자열을 읽어낸다
					String msg = br.readLine();
					// 전송된 JSON 문자열을 사용할 준비를 한다
					JSONObject jsonObj = new JSONObject(msg);
					// type을 읽어낸다
					String type = jsonObj.getString("type");
					if(type.equals("enter")) {
						// 현재 스레드가 대응하는 클라이언트의 대화명을 필드에 저장
						String chatName = jsonObj.getString("name");
						this.chatName = chatName;
						// 대화명 목록을 보내준다
						sendChatNameList();
					}
					
					// 클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다
					sendMessage(msg);
					if(msg == null) {// 클라이언트의 접속이 끊겼기 때문에
						break; // 반복문(while)을 빠져나오도록 한다
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				// 접속이 끊겨서 종료되는 스레드는 List에서 제거한다
				threadList.remove(this);
				// this가 퇴장한다고 메시지를 보낸다
				try {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", this.chatName);
					sendMessage(jsonObj.toString());
					// 대화명 목록을 보내준다
					sendChatNameList();
					if(socket != null)socket.close();
				}catch (Exception e) {}
			}
		}
	}
}

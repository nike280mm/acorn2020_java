package test.frame4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	// default 생성자
	public MyFrame() {
		// 레이아웃 매니저 지정
		setLayout(new FlowLayout());
		// 버튼
		JButton sendBtn = new JButton("전송");
		JButton removeBtn = new JButton("삭제");
		// 프레임에 버튼 추가하기 (FlowLayout의 영향을 받는다)
		add(sendBtn);
		add(removeBtn);
		
		// ActionListener 인터페이스 type의 참조값
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("전송합니다");
				
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다");
			}
			
		};
		ActionListener listener2 = (e)->{};
		
		sendBtn.addActionListener(listener);
		// lamda식 활용해보기
		removeBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다");
		});
	}
	
	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame에 담기
		MyFrame frame = new MyFrame();
		// 프레임 제목 설정
		frame.setTitle("나의 후뤠임");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록 한다
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
}
package test.frame5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	
	// default 생성자
	public MyFrame() {
		// 레이아웃 매니저 지정
		setLayout(new FlowLayout());
		// 버튼
		JButton sendBtn = new JButton("전송");
		JButton removeBtn = new JButton("삭제");
		
		// 버튼에 command 등록하기 (어떤 기능을 하는 버튼인지)
		sendBtn.setActionCommand("send");
		removeBtn.setActionCommand("remove");
		
		// 프레임에 버튼 추가하기 (FlowLayout의 영향을 받는다)
		add(sendBtn);
		add(removeBtn);
		
		MyFrame a = this;
		JFrame b = this;
		ActionListener c = this;
		
		// MyFrame 객체의 참조값을 전달해서 리스너 등록하기
		sendBtn.addActionListener(this);
		removeBtn.addActionListener(this);
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
	// ActionListener 인터페이스르 구현해서 강제 오버라이드 된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(this, "버튼이 눌렸습니다");
		String a = e.getActionCommand();
		if(a.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송합니다");
		}else if(a.equals("remove")){
			JOptionPane.showMessageDialog(this, "삭제합니다");
		}
	}
}
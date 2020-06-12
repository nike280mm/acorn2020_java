package test.frame7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	
	JTextField inputMsg;
	
	// default 생성자
	public MyFrame() {
		setLayout(new FlowLayout());
		// 문자열 한 줄을 입력할 수 있는 JTextField
		JTextField inputMsg = new JTextField(10);
		add(inputMsg);

		JButton sendBtn = new JButton("전송");
		sendBtn.addActionListener(this);
		add(sendBtn);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = inputMsg.getText();
		JOptionPane.showMessageDialog(this, a);
	}
}
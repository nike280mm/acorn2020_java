package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame01 extends JFrame implements ActionListener{
	
	// 생성자
	public Frame01() {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel, BorderLayout.NORTH);
		
		JButton alertBtn = new JButton("알림 띄우기");
		panel.add(alertBtn);
		
		// 버튼에 리스너 등록하기
		alertBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame에 담기
		Frame01 frame = new Frame01();
		// 프레임의 제목 설정
		frame.setTitle("Frame01");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록 한다
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "롸?");
		System.out.println("알림창을 닫았습니다");
		
		try {
			System.out.println("5초 동안 무언가 준비 작업을 한다");
			Thread.sleep(5000);
		}catch (InterruptedException exe) {
			exe.printStackTrace();
		}
	}
}


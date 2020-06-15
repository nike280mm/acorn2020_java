package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountRunnable;
import test.mypac.CountThread;

public class Frame04 extends JFrame implements ActionListener{
	
	// 생성자
	public Frame04() {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel, BorderLayout.NORTH);
		
		JButton alertBtn = new JButton("1 ~ 10까지 센다");
		panel.add(alertBtn);
		
		// 버튼에 리스너 등록하기
		alertBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame에 담기
		Frame04 frame = new Frame04();
		// 프레임의 제목 설정
		frame.setTitle("Frame01");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록 한다
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Runnable 인터페이스를 구현한 클래스로 객체 생성
		Runnable r = new Runnable() {
			@Override
			public void run() {
				int count = 0;
				
				while(true) {
					try {
						Thread.sleep(1000);
					}catch(InterruptedException exe) {
						exe.printStackTrace();
					}
					count++; // count를 1 증가 시킨다
					System.out.println("현재 카운트: "+count);
					if(count==10) {// 카운트가 10이 되면
						break; // 반복문 탈출
					}
				}
			}
		};
		// Thread 객체를 생성하면서 생성자의 인자로 전달한다
		Thread t = new Thread(r);
		// start() 메소드를 호출해서 새로운 스레드를 시작한다
		t.start();
		System.out.println("새로운 스레드를 시작했습니다");
	}
}


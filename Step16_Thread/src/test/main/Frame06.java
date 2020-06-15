package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountRunnable;
import test.mypac.CountThread;

public class Frame06 extends JFrame implements ActionListener{
	// 필드
	JLabel label_result;
	
	// 내부 클래스
	class CountThread extends Thread{
		@Override
		public void run() {
			// run() 메소드 안쪽이 새로운 작업단위가 된다`
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
			/*
			 * 	내부클래스의 메소드 안에서 바깥쪽에 클래스의 필드와
			 * 	메소드를 사용할 수 있다
			 */
			label_result.setText("작업 종료");
		}// run()
	}// class CountThread
	
	// 생성자
	public Frame06() {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel, BorderLayout.NORTH);
		
		JButton alertBtn = new JButton("1 ~ 10까지 센다");
		panel.add(alertBtn);
		
		// 버튼에 리스너 등록하기
		alertBtn.addActionListener(this);
		
		// JLabel
		label_result = new JLabel();
		panel.add(label_result);
	}
	
	public static void main(String[] args) {
		// MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame에 담기
		Frame06 frame = new Frame06();
		// 프레임의 제목 설정
		frame.setTitle("Frame01");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록 한다
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent args) {
		// 내부 클래스를 이용해서 스레드 객체를 생성해서 시작 시킨다
		new CountThread().start();
	}
}


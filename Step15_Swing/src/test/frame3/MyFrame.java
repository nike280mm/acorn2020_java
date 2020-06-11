package test.frame3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	// 생성자
	public MyFrame(String title) {
		super(title);
		
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 레이아웃 메니저를 FlowLayout으로 지정
		setLayout(new BorderLayout());
		
		JButton btn1 = new JButton("붕가");
		btn1.setSize(100, 30);
		add(btn1, BorderLayout.EAST);

		JButton btn2 = new JButton("붕가");
		btn2.setSize(100, 30);
		add(btn2, BorderLayout.WEST);

		JButton btn3 = new JButton("슉");
		btn3.setSize(100, 30);
		add(btn3, BorderLayout.SOUTH);

		JButton btn4 = new JButton("슉");
		btn4.setSize(100, 30);
		add(btn4, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}

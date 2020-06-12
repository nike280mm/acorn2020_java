package test.frame10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;


public class Calculator extends JFrame implements ActionListener, KeyListener{

	JTextField inputNum1;
	JTextField inputNum2;
	
	JButton plusBtn;
	JButton minusBtn;
	JButton multiBtn;
	JButton diviBtn;
	
	JLabel lab1;
	
	public Calculator() {
		
		setLayout(new BorderLayout());
		inputNum1 = new JTextField(5);
		
		// +
		plusBtn = new JButton("+");
		plusBtn.setActionCommand("plus");
		plusBtn.addActionListener(this);
		
		// -
		minusBtn = new JButton("-");
		minusBtn.setActionCommand("minus");
		minusBtn.addActionListener(this);
		
		// *
		multiBtn = new JButton("*");
		multiBtn.setActionCommand("multi");
		multiBtn.addActionListener(this);
		
		// /
		diviBtn = new JButton("/");
		diviBtn.setActionCommand("divi");
		diviBtn.addActionListener(this);
		
		inputNum2 = new JTextField(5);
		
		inputNum2.addKeyListener(this);
		
		// JLabel 객체 생성
		lab1 = new JLabel("값은?");
		
		// JPanel 객체 생성
		JPanel panel = new JPanel();
		
		// JPanel에 UI 추가
		panel.add(inputNum1);
		panel.add(plusBtn);
		panel.add(minusBtn);
		panel.add(multiBtn);
		panel.add(diviBtn);
		panel.add(inputNum2);
		
		// JPanel 배경색 지정
		panel.setBackground(Color.GREEN);
		
		// JFrame에 JPanel을 북쪽에 배치
		this.add(panel, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		// 프레임 제목 설정
		cal.setTitle("휘뚜루마뚜루 계산기");
		// 프레임을 닫으면 자동으로 프로세스가 종료되도록 한다
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cal.setBounds(100, 100, 700, 300);
		cal.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void plus() {
		String num1 = inputNum1.getText();
		String num2 = inputNum2.getText();
		lab1.setText(" = "+ num1 + num2);
	}
	public void minus() {
		String num1 = inputNum1.getText();
		String num2 = inputNum2.getText();
		lab1.setText(" = "+ num1 - num2);
	}
	public void multi() {
		String num1 = inputNum1.getText();
		String num2 = inputNum2.getText();
		
		lab1.setText(" = "+ num1 * num2);
	}
	public void divi() {
		String num1 = inputNum1.getText();
		String num2 = inputNum2.getText();
		
		lab1.setText(" = "+ );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}


}

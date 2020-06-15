package test.frame10;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{
	// 필드
	JTextField tf_num1, tf_num2;
	JLabel label_result;
	
	// default 생성자
	public MyFrame() {
		// 프레임의 레이아웃 법칙 설정하기
		setLayout(new BorderLayout());
		
		// Panel
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.YELLOW);
		
		// Panel을 북쪽에 배치하기
		add(topPanel, BorderLayout.NORTH);
		
		// JTextField 객체를 만들어서 JPanel에 추가하기
		tf_num1 = new JTextField(10);
		topPanel.add(tf_num1);
		
		// 기능 버튼 객체를 만들어서 JPanel에 추가하기
		JButton plusBtn = new JButton("+");
		JButton minusBtn = new JButton("-");
		JButton multiBtn = new JButton("*");
		JButton divideBtn = new JButton("/");
		topPanel.add(plusBtn);
		topPanel.add(minusBtn);
		topPanel.add(multiBtn);
		topPanel.add(divideBtn);
		
		// 두 번째 JTextField 만들어서 패널에 추가
		tf_num2 = new JTextField(10);
		topPanel.add(tf_num2);
		
		// JLabel
		JLabel label1 = new JLabel("=");
		label_result = new JLabel("0");
		
		// 패널에 레이블 추가
		topPanel.add(label1);
		topPanel.add(label_result);
		
		// 버튼에 리스너 등록
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		
		// 버튼에 액션 command 지정
		plusBtn.setActionCommand("plus");
	    minusBtn.setActionCommand("minus");
		multiBtn.setActionCommand("multi");
		divideBtn.setActionCommand("divide");
		
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setTitle("계산기");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 300);
		frame.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// JTextField에 입력한 문자열을 읽어와서 숫자(실수)로 바꿔준다
			double num1 = Double.parseDouble(tf_num1.getText());
			double num2 = Double.parseDouble(tf_num2.getText());
			// 연ㅅㄴ의 결과값을 담을 지역 변수
			double result = 0;
			// 눌러진 버튼의 command 읽어오기
			String command = e.getActionCommand();
			
			if(command.equals("plus")) {
				result = num1 + num2;
			}else if(command.equals("minus")) {
				result = num1 - num2;
			}else if(command.equals("multi")) {
				result = num1 * num2;
			}else if(command.equals("divide")) {
				result = num1 / num2;
			}
			// 결과값을 JLable에 출력하기
			label_result.setText(Double.toString(result));
		}catch (Exception exe) {
			JOptionPane.showMessageDialog(this, "숫자를 입력합시다");	
			tf_num1.setText("");
			tf_num2.setText("");
		}
	}
}

package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Quiz02 extends JFrame implements ActionListener{
	FileReader fr = null;
	BufferedReader br = null;
	
	JTextArea ta;
	JTextField tf_msg;
	static File quiz;
	static final String COMMAND_APPEND = "append";
	static final String COMMAND_LOAD = "load";
	static final String COMMAND_CLEAR = "clear";
	
	// 생성자
	public Quiz02() {
		setTitle("휘뚜루 마뚜루");
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		tf_msg = new JTextField(10);
		
		
		JButton appendBtn = new JButton("append");
		appendBtn.setActionCommand(COMMAND_APPEND);
		appendBtn.addActionListener(this);
		
		JButton loadBtn = new JButton("load");
		loadBtn.setActionCommand(COMMAND_LOAD);
		loadBtn.addActionListener(this);

		JButton clearBtn = new JButton("clear");
		clearBtn.setActionCommand(COMMAND_CLEAR);
		clearBtn.addActionListener(this);
		
		topPanel.add(tf_msg);
		topPanel.add(appendBtn);
		topPanel.add(loadBtn); 
		topPanel.add(clearBtn); 
		add(topPanel, BorderLayout.NORTH);
		topPanel.setBackground(Color.yellow);
		
		ta = new JTextArea();
		add(ta, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		Quiz02 f = new Quiz02();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		quiz = new File("c:/acorn2020/myFolder/quiz02.txt");
		
	}
	
	public void append() {
			
		String txt = tf_msg.getText();
		
		try {
			boolean isExists = quiz.exists();
			if(!isExists) {
				quiz.createNewFile();
			}
			FileWriter fw = new FileWriter(quiz, true);
			fw.append(txt);
			fw.append("\r\n");
			fw.close();
			JOptionPane.showMessageDialog(this, "저장됨");
			tf_msg.setText("");
						
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void load() {
		// JTextArea를 clear하고 실행
		ta.setText("");
		
		try {
			boolean isExists = quiz.exists();
			if(!quiz.exists()) {
				JOptionPane.showMessageDialog(this, "파일이 없수다");
				return; 
			}
			// 파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어둔 지역 변수에 담는다
			fr = new FileReader(quiz);
			br = new BufferedReader(fr);
			while(true) {
				// 반복문 돌면서 문자열을 줄 단위로 (개행기호 기준) 읽어낸다
				String line = br.readLine();
				if(line == null) {// 더 이상 읽을 문자열이 없으면
					break; // 반복문 탈출
				}
				// 읽은 문자열 출력하기
				ta.append(line);
				ta.append("\n");
				tf_msg.setText("");
			}
			JOptionPane.showMessageDialog(this, "출력이 완료됐습니다");
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {// 예외가 발생하던 안 하던 반드시 실행이 보장되는 블럭
			// 마무리 작업을 한다 (보통 열었던 스트림 객체를 닫는 작업을 한다)
			try {
				// null 체크를 한 다음에 메소드를 호출해서 마무리 작업을 한다
				if(fr != null)fr.close();
				if(br != null)br.close();
			}catch (IOException ie) {}
		}
	}
	
	public void clear() {
		ta.setText("");
		
		JOptionPane.showMessageDialog(this, "삭제했습니다");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.contentEquals(COMMAND_APPEND)) {
			append();
		}
		if(command.contentEquals(COMMAND_LOAD)) {
			load();
		}
		if(command.contentEquals(COMMAND_CLEAR)) {
			clear();
		}
	}
}

package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz03 extends JFrame implements ActionListener{
	
	FileReader fr = null;
	BufferedReader br = null;
	
	JTextArea area;
	
	// 생성자
	public Quiz03() {
		
		setTitle("나의 파일");
		setLayout(new BorderLayout());
		// 메뉴 아이템
		JMenuItem item_new = new JMenuItem("New");
		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_save = new JMenuItem();
		// 아이템 text를 메소드를 이용해서 전달 가능
		item_save.setText("Save");
		
		item_new.setActionCommand("new");
		item_open.setActionCommand("open");
		item_save.setActionCommand("save");
		
		item_new.addActionListener(this);
		item_open.addActionListener(this);
		item_save.addActionListener(this);
		
		// 메뉴에 아이템 추가
		JMenu menu1 = new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		
		JMenu menu2 = new JMenu();
		menu2.setText("도움말");
		
		// 메뉴바에 메뉴 추가
		JMenuBar mb = new JMenuBar();
		mb.add(menu1);
		mb.add(menu2);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		// 텍스트 area를 프레임의 가운데에 배치
		area = new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.white);
		area.setVisible(false);
	}
	
	public static void main(String[] args) {
		Quiz03 f = new Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 아이템의 액션 command를 읽어온다
		String command = e.getActionCommand();
		if(command.contentEquals("new")) {// 아이템 new를 눌렀을 때
			area.setVisible(true); // JTextArea를 보이게 하고
			area.setText("");
			area.grabFocus(); // 포커스를 준다
		}else if(command.equals("open")) {
			area.setText("");
			Open();
		}else if(command.equals("save")) {// 아이템 save를 눌렀을 때
			Save();
		}
	}
	
	public void Open() {
		area.setVisible(true);
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		int result = fc.showOpenDialog(this);
		File file = fc.getSelectedFile();
		if(result == JFileChooser.APPROVE_OPTION) {
			try {
				// 파일에서 문자열을 읽어들일 객체의 참조값을 미리 만들어둔 지역 변수에 담는다
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while(true) {
					// 반복문 돌면서 문자열을 줄 단위로 (개행기호 기준) 읽어낸다
					String line = br.readLine();
					if(line == null) {// 더 이상 읽을 문자열이 없으면
						break; // 반복문 탈출
					}
					// 읽은 문자열 출력하기
					area.append(line);
					area.append("\r\n");
				}
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
	}
	
	// 파일을 저장하는 메소드
	public void Save() {
		// JTextArea에 입력한 문자열을 읽어온다
		String content = area.getText();
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			// 새로 만들 예정인 File 객체의 참조값 얻어오기
			File file = fc.getSelectedFile();
			// 파일에 문자열을 출력할 수 있는 객체 생성
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(content);
				fw.close();
				JOptionPane.showMessageDialog(this, file.getName() + "로 저장 했슈");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

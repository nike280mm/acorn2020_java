package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz03 extends JFrame implements ActionListener{
	// 생성자
	public Quiz03() {
		
		setTitle("나의 파일");
		setLayout(new BorderLayout());
		// 메뉴 아이템
		JMenuItem item_new = new JMenuItem("New");
		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_save = new JMenuItem("Save");
		
		item_new.setActionCommand("new");
		item_new.addActionListener(this);
		
		item_open.setActionCommand("open");
		item_open.addActionListener(this);
		
		item_save.setActionCommand("save");
		item_save.addActionListener(this);
		
		// 메뉴에 아이템 추가
		JMenu menu1 = new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		// 메뉴바에 메뉴 추가
		JMenuBar mb = new JMenuBar();
		mb.add(menu1);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		// 텍스트 area를 프레임의 가운데에 배치
		JTextArea area = new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.GREEN);
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
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		int result = fc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			// 선택한 파일을 access 할 수 있는 파일 객체
			File selectedFile = fc.getSelectedFile();
		}else if(result == JFileChooser.CANCEL_OPTION) {
			
		}else if(result == JFileChooser.ERROR_OPTION) {
			
		}
	}
}

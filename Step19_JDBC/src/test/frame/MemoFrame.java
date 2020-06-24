package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dao.MemoDao;
import test.util.MemoDto;

/*
 * 	CREATE TABLE MEMO
 * 	(num NUMBER PRIMARY KEY, 
 * 	 content VARCHAR2(30), 
 * 	 regdate DATE);
 * 
 * 	CREATE SEQUENCE MEMO_SEQ;
 * 
 * 	위와 같이 테이블과 시퀀스를 만들고 해당 테이블에 데이터를 
 * 	SELECT, INSERT, UPDATE, DELETE 기능을 수행할 수 있는 MemoFrame을 만들기
 * 
 * 	조건
 * 	1. num 칼럼의 값은 시퀀스를 이용해서 넣기
 * 	2. regdate 칼럼(등록일)의 값은 SYSDATE를 이용하기
 * 	3. 수정은 content 만 수정가능하게 하기
 * 	4. MemoDto, MemoDao를 만들어서 프로그래밍 하기
 */

public class MemoFrame extends JFrame implements ActionListener, KeyListener, PropertyChangeListener{
	
	MemoDto dto;
	MemoDao dao;
	
	DefaultTableModel model;
	List<MemoDto> list;
	JTextField inputMemo;
	JTable table;
	
	int sel_mem; 
	int sel_row;
	
	public MemoFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("메모");
		inputMemo = new JTextField(10);
		inputMemo.addKeyListener(this);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton removeBtn = new JButton("삭제");
		removeBtn.setActionCommand("remove");
		removeBtn.addActionListener(this);
		
		JButton editBtn = new JButton("수정");
		editBtn.setActionCommand("edit");
		editBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputMemo);
		panel.add(saveBtn);
		panel.add(removeBtn);
		panel.add(editBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table = new JTable();
		table.addKeyListener(this);
		
		String[] colNames = {"번호", "내용", "날짜"};
		
		model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				if(column == 0 || column == 2) {
					return false;
				}
				return true;
			};
		};
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
	
		table.addPropertyChangeListener(this);
		
		displayMemo();
		
	}
	
	public static void main(String[] args) {
		MemoFrame f = new MemoFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void displayMemo() {
		model.setRowCount(0);
		
		dao = MemoDao.getInstance();
		list = dao.getList();
		
		for(MemoDto tmp : list) {
			Object[] row = {tmp.getNum(), tmp.getContent(), tmp.getRegdate()};
			
			model.addRow(row);
		}
	}
	public void save() {
		dto = new MemoDto();
		String content = inputMemo.getText();
		dto.setContent(content);
		dao.insert(dto);
		displayMemo();
		inputMemo.setText("");
	}
	
	public void remove() {
		sel_row = table.getSelectedRow();
		sel_mem = list.get(sel_row).getNum();
		
		if(sel_row > 0) {
			int result = JOptionPane.showConfirmDialog(this, "삭제할까요?");
			if(result == JOptionPane.YES_OPTION) {
				dao.delete(sel_mem);
			}
			displayMemo();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("save")) {
			save();
		}else if(command.equals("remove")) {
			int a = table.getSelectedRow();
			if(a == -1) {
				return;
			}
			remove();
		}
	}
	
	boolean isEditable = false;
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		System.out.println("property change");
		System.out.println(arg0.getPropertyName());
		if(arg0.getPropertyName().equals("tableCellEditor")) {
			if(isEditable) {
				int sel_row = table.getSelectedRow();
				
				int num = (int)table.getValueAt(sel_row, 0);
				String content = (String)table.getValueAt(sel_row, 1);
				
				dto = new MemoDto(num, content, null);
				dao.update(dto);
				
				isEditable = false;
			}
			isEditable = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			dto = new MemoDto();
			String text = inputMemo.getText();
			dto.setContent(text);
			dao.insert(dto);
			displayMemo();
			inputMemo.setText("");
		}
		if(code == KeyEvent.VK_DELETE) {
			sel_row = table.getSelectedRow();
			sel_mem  = list.get(sel_row).getNum();
			
			if(sel_row > 0) {
				int result = JOptionPane.showConfirmDialog(this, "삭제할까요?");
				if(result == JOptionPane.YES_OPTION) {
					dao.delete(sel_mem);
				}
				displayMemo();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}

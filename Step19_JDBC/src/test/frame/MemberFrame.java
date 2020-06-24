package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import javax.swing.text.StyledEditorKit.AlignmentAction;

import test.dao.MemberDao;
import test.util.DBConnect;
import test.util.MemberDto;

public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{

	MemberDao dao = MemberDao.getInstance();
	MemberDto dto;
	List<MemberDto> list;
	DefaultTableModel model;
	JTable table;
	JTextField inputName;
	JTextField inputAddr;
	
	// 생성자
	public MemberFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(10);

		JLabel label2 = new JLabel("주소");
		inputAddr = new JTextField(10);
		
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
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(removeBtn);
		panel.add(editBtn);
		
		add(panel, BorderLayout.NORTH);
		
		// 표형식으로 정보를 출력하기 위한 JTable
		table = new JTable();
		// 칼럼명을 String[]에 순서대로 준비
		String[] colNames = {"번호", "이름", "주소"};
		// 테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 갯수)
		model = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// 만일 첫 번째 칼럼이면 수정 불가하도록
				if(column == 0) {
					return false;
				}
				return true;
			}
		};
		// 모델을 테이블에 연결
		table.setModel(model);
		
		// 스크롤이 가능하도록 테이블을 JScrollPane 에 감싼다
		JScrollPane scroll = new JScrollPane(table);
		// JScrollPane 을 프레임의 가운데에 배치
		add(scroll, BorderLayout.CENTER);
		// 테이블에서 발생하는 이벤트 리스너 등록하기
		table.addPropertyChangeListener(this);
		displayMember();
		
	}
	// 테이블에 회원 목록을 출력하는 메소드
	public void displayMember() {
		// 
		model.setRowCount(0);
		
		MemberDao dao = MemberDao.getInstance();
		list = dao.getList();
		
		for(MemberDto tmp : list) {
			// MemberDto 객체에 저장된 정보를 Object[] 객체에 순서대로 담는다
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			
			model.addRow(row);
		}
	}
	
	// main 메소드
	public static void main(String[] args) {
		MemberFrame f = new MemberFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void save() {
		dto = new MemberDto();
		
		String name = inputName.getText();
		String addr = inputAddr.getText();
		
		dto.setName(name);
		dto.setAddr(addr);
		
		boolean isSuccess = dao.insert(dto);
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, name + "의 정보가 추가됐습니다");
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패");
		}
		displayMember();
	}
	
	public void remove() {
		
		int a = table.getSelectedRow();
		
		int num = list.get(a).getNum();
//		int num = (int)model.getValueAt(a, 0);
		
		if(a >= 0) {
			int result = JOptionPane.showConfirmDialog(this, "삭제합니까?");
			if(result == JOptionPane.YES_OPTION) {
				dao.delete(num);
			}
			displayMember();
		}
	}
	
	public void edit() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("save")) {
			save();
		}
		if(command.equals("remove")) {
			int a = table.getSelectedRow();
			if(a == -1) {
				return;
			}
			remove();
		}
	}

	// 현재 테이블 cell을 수정 중인지 확인
	boolean isEditing = false;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("property change");
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {// 수정 중일 때
				// 변화 된 값을 읽어와서 DB에 반영한다
				// 수정 된 칼럼에 있는 row 전체 값을 읽어온다
				int sel_row = table.getSelectedRow();
				int num = (int)model.getValueAt(sel_row, 0);
				String name = (String)model.getValueAt(sel_row, 1);
				String addr = (String)model.getValueAt(sel_row, 2);
				// 수정할 회원의 정보를 MemberDto 객체에 담고
				dto = new MemberDto(num, name, addr);
				// DB에 저장하기
				dao.update(dto);
				isEditing = false; // 수정 중이 아니라고 표시한다
			}
			isEditing = true;
		}
//		evt.getOldValue();
//		evt.getNewValue();
	}
}

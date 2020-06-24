package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import test.dao.MemberDao;
import test.dao.TodoDao;
import test.util.TodoDto;

public class TodoFrame extends JFrame implements ActionListener, PropertyChangeListener{
	
	TodoDao dao;
	TodoDto dto;
	
	DefaultTableModel model;
	List<TodoDto> list;
	JTextField inputTodo;
	JTable table;
	
	public TodoFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("할 일");
		inputTodo = new JTextField(10);
		inputTodo.addActionListener(this);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton delBtn = new JButton("삭제");
		delBtn.setActionCommand("delete");
		delBtn.addActionListener(this);
		
		JButton editBtn = new JButton("수정");
		editBtn.setActionCommand("edit");
		editBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputTodo);
		panel.add(saveBtn);
		panel.add(delBtn);
		panel.add(editBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table = new JTable();
		
		String[] colNames = {"순서", "할 일", "언제까지"};
		
		model = new DefaultTableModel(colNames, 0);
		
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		table.addPropertyChangeListener(this);
		
		displayTodo();
	}
	
	public static void main(String[] args) {
		TodoFrame f = new TodoFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void displayTodo() {
		
		model.setRowCount(0);
		
		dao = TodoDao.getInstance();
		list = dao.getList();
		for(TodoDto tmp : list) {
			Object[] row = {tmp.getNum(), tmp.getTodo(), tmp.getTill()};
			
			model.addRow(row);
		}
	}
	
	public void save() {
		dto = new TodoDto();
		String todo = inputTodo.getText();
		
		dto.setTodo(todo);
		dao.insert(dto);
		displayTodo();
	}
	
	public void delete() {
		int sel_row = table.getSelectedRow();
		int sel_num = list.get(sel_row).getNum();
		int confirm = JOptionPane.showConfirmDialog(this, "참말로?");
		if(confirm == JOptionPane.YES_OPTION) {
			dao.delete(sel_num);
		}else{
			return;
		}
		displayTodo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if(command.equals("save")) {
			save();
		}else if(command.equals("delete")) {
			delete();
		}else if(command.equals("edit")) {
			
		}
		
	}
	boolean isEditing = false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().contentEquals("tableCellEditor")) {
			if(isEditing) {
				int sel_row = table.getRowCount();
				
				int num = (int)table.getValueAt(sel_row, 0);
				String todo = (String)table.getValueAt(sel_row, 1);
				String till = (String)table.getValueAt(sel_row, 2);
				
				dto = new TodoDto(num, todo, till);
				dao.update(dto);
				
				isEditing = false;
			}
			isEditing = true;
		}
	}
}

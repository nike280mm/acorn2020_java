package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.TodoDao;
import test.util.TodoDto;

public class TodoFrame extends JFrame implements ActionListener, PropertyChangeListener{
	
	TodoDto dto;
	TodoDao dao;
	
	List<TodoDto> list;	
	DefaultTableModel model;
	JTextField inputTodo;
	JTable table;
	
	public TodoFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel();
		inputTodo = new JTextField(10);
		
		JButton saveBtn = new JButton("저장");
		JButton delBtn = new JButton("삭제");
		JButton editBtn = new JButton("수정");
		
		saveBtn.setActionCommand("save");
		delBtn.setActionCommand("del");
		editBtn.setActionCommand("edit");
		
		saveBtn.addActionListener(this);
		delBtn.addActionListener(this);
		editBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputTodo);
		panel.add(saveBtn);
		panel.add(delBtn);
		panel.add(editBtn);
		
		add(panel, BorderLayout.NORTH);
		
		table = new JTable();
		
		String[] colNames = {"순번", "할 일", "기한"};
		
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
		String todo = inputTodo.getText();
		dto = new TodoDto();
		dto.setTodo(todo);
		dao = TodoDao.getInstance();
		dao.insert(dto);
		
		displayTodo();
		
		inputTodo.setText("");
	}
	
	public void delete() {
		int sel_row = table.getSelectedRow();
		int sel_todo = (int)list.get(sel_row).getNum();
		
		dao = TodoDao.getInstance();
		dao.delete(sel_todo);
		
		displayTodo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("save")) {
			save();
		}else if(command.equals("del")) {
			delete();
		}
	}
	boolean isEditing = false;
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		System.out.println(arg0.getPropertyName());
		if(isEditing) {
			int sel_row = table.getSelectedRow();
			
			int num = (int)model.getValueAt(sel_row, 0);
			String todo = (String)model.getValueAt(sel_row, 1);
			
			dto = new TodoDto(num, todo, null);
			dao = TodoDao.getInstance();
			dao.update(dto);
			
			isEditing = false;
		}
		isEditing = true;
	}
}

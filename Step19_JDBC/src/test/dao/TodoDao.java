package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.util.DBConnect;
import test.util.TodoDto;

/*
 *  DAO (Data Access Object)
 *  
 *  <만드는 방법>
 *  1. 외부에서 객체 생성하지 못하도록 생성자의 접근 지정자를 private로 지정
 *  2. 자신의 참조값을 지정할 수 있는 필드를 private로 선언
 *  3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드 만들기
 *  4. 나머지 기능(select, insert, update, delete)들은 non static으로 만듬
 *  
 */
public class TodoDao {
	// 자신의 참조값을 지정할 private 필드
	private static TodoDao dao;
	
	// 외부에서 객체 생성하지 못하도록 한다
	private TodoDao() {}
	
	// 참조값을 리턴해주는 메소드
	public static TodoDao getInstance() {
		if(dao == null) {// 최초 호출되면 null이므로
			dao = new TodoDao(); // 객체를 생성해서 static 필드에 담는다
		}
		return dao;
	}
	
	// 회원 한 명의 정보를 리턴해주는 메소드
	public TodoDto getData(int num) {
		
		TodoDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT todo, till FROM todo"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new TodoDto(num, rs.getString("todo"), rs.getString("till"));
				System.out.println(num + " | " + rs.getString("todo") + " | " + rs.getString("till"));
				System.out.println("내용을 뽑았습니다");
			}else {
				System.out.println(num + "번의 내용이 없습니다");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
		return dto;
	}
	
	// 메모 목록을 리턴해주는 메소드
	public List<TodoDto> getList(){
		List<TodoDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			
			String sql = "SELECT num, todo, TO_CHAR(SYSDATE, 'YY.MM.DD AM HH:MI:SS') till FROM todo"
						+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String todo = rs.getString("todo");
				String till = rs.getString("till");
				
				TodoDto dto = new TodoDto(num, todo, till);
				list.add(dto);
			}
			System.out.println("메모를 불러왔습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	public boolean insert(TodoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "INSERT INTO todo"
						+ " (num, todo, till)"
						+ " VALUES(todo_seq.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTodo());
			// sql문을 수행하고 변환된 row의 갯수를 리턴 받는다 (리턴값: 1)
			flag = pstmt.executeUpdate();
			System.out.println("메모를 추가했습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(TodoDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE todo"
						+ " SET todo = ?"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTodo());
			pstmt.setInt(2, dto.getNum());
			flag = pstmt.executeUpdate();
			System.out.println("메모를 수정했습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	}	
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM todo"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
			}catch (Exception e) {}
		}
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	}
}

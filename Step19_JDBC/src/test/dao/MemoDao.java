package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.util.DBConnect;
import test.util.MemoDto;

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
public class MemoDao {
	// 자신의 참조값을 지정할 private 필드
	private static MemoDao dao;
	
	// 외부에서 객체 생성하지 못하도록 한다
	private MemoDao() {}
	
	// 참조값을 리턴해주는 메소드
	public static MemoDao getInstance() {
		if(dao == null) {// 최초 호출되면 null이므로
			dao = new MemoDao(); // 객체를 생성해서 static 필드에 담는다
		}
		return dao;
	}
	
	// 회원 한 명의 정보를 리턴해주는 메소드
	public MemoDto getData(int num) {
		
		MemoDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT content, regdate FROM memo"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemoDto(num, rs.getString("content"), rs.getString("regdate"));
				System.out.println(num + " | " + rs.getString("content") + " | " + rs.getString("regdate"));
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
	public List<MemoDto> getList(){
		List<MemoDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			
			String sql = "SELECT num, content, TO_CHAR(SYSDATE, 'YY.MM.DD AM HH:MI:SS') regdate FROM memo"
						+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				
				MemoDto dto = new MemoDto(num, content, regdate);
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
	
	public boolean insert(MemoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		
		try {
			conn = new DBConnect().getConn();
			
			String sql = "INSERT INTO memo"
						+ " (num, content, regdate)"
						+ " VALUES(memo_seq.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
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
	
	public boolean update(MemoDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE memo"
						+ " SET content = ?, SYSDATE"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
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
			String sql = "DELETE FROM memo"
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

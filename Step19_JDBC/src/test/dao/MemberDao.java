package test.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import test.util.DBConnect;
import test.util.MemberDto;

/*
 * 	DAO (Data Access Object)
 * 
 * 	<만드는 방법>
 * 	1. 외부에서 객체 생성하지 못하도록 생성자의 접근 지정자를 private로 지정
 * 	2. 자신의 참조값을 지정할 수 있는 필드를 private로 선언
 * 	3. 자신의 참조값을 오직 ㅎ나ㅏ만 생성해서 리턴해주는 static 메소드 만들기
 * 	4. 나머지 기능(select, insert, update, delete)들은 non static 으로 만듬
 * 
 */
public class MemberDao {
	// 자신의 참조값을 지정할 private 필드
	private static MemberDao dao;
	
	// 외부에서 객체 생성하지 못하도록 한다
	private MemberDao() {}
	
	// 참조값을 리턴해주는 메소드
	public static MemberDao getInstance() {
		if(dao == null) {// 최초 호출되면 null이므로
			dao = new MemberDao(); // 객체를 생성해서 static 필드에 담는다
		}
		return dao;
	}
	
	// 회원 한 명의 정보를 리턴해주는 메소드
	public MemberDto getData(int num) {
		
		MemberDto dto = new MemberDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT name, addr FROM member"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDto(num, rs.getString("name"), rs.getString("addr"));
				System.out.println(num + " | " + rs.getString("name") + " | " + rs.getString("addr"));
			}else {
				System.out.println(num + "번 회원의 정보가 없습니다");
			}
			System.out.println("회원 정보를 뽑았습니다");
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
	
	// 회원 목록을 리턴해주는 메소드
	public List<MemberDto> getList(){
		List<MemberDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다
			conn = new DBConnect().getConn();
			// 실행할 sql문
			String sql = "select * from member"
						+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			// query 문 수행하고 결과 얻어오기
			rs = pstmt.executeQuery();
			// 반복문 돌면서 select 된 회원정보 읽어오기
			while(rs.next()) {
				// 회원 정보를 list에 담기
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				// MemberDto 객체를 생성해서 회원 한 명의 정보를 담는다
				MemberDto dto = new MemberDto(num, name, addr);
				// MemberDto 객체를 List에 누적 시킨다
				list.add(dto);
				System.out.println(num + " | " + name + " | " + addr);
			}
			System.out.println("회원 목록을 불러왔습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// 객체를 생성했던 순서의 역순으로 닫는다
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	// 회원 한 명의 정보를  DB에서 삭제하는 메소드
	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT name, addr FROM member"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sql2 = "DELETE FROM member"
						+ " WHERE num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
				System.out.println("회원 정보를 삭제했습니다");
			}else {
				System.out.println("삭제할 정보가 없습니다");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
	}
	// 회원 정보를 DB에 저장하는 메소드
	public void insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		dto = new MemberDto();
		
		Scanner scan_name = new Scanner(System.in);
		System.out.println("name: ");
		String name = scan_name.nextLine();
		
		Scanner scan_addr = new Scanner(System.in);
		System.out.println("addr: ");
		String addr = scan_addr.nextLine();
		
		dto.setName(name);
		dto.setAddr(addr);
		
		try {
			conn = new DBConnect().getConn();
			String sql = "INSERT INTO member" 
						+" (num, name, addr)"
						+" VALUES(5, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
			System.out.println("회원 정보를 추가했습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {}
		}
	}
	// 회원 정보를 DB에서 수정하는 메소드
	public void update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE member"
						+ " SET name = ?, addr = ?"
						+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)pstmt.close();
			}catch (Exception e) {}
		}
	}
}

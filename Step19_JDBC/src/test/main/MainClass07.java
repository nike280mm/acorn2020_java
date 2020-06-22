package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.util.DBConnect;
import test.util.MemberDto;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 	member테이블에 저장된 회원의 정보를
		 * 	번호에 대해서 오름차순 정렬해서
		 *  List<MemberDto> 객체에 담아오려고 한다
		 */
		
		// 회원 목록을 담을 객체 생성
		List<MemberDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다
			conn = new DBConnect().getConn();
			// 실행할 sql문
			String sql = "select * from member";
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
				MemberDto dto = new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				// MemberDto 객체를 List에 누적 시킨다
				list.add(dto);
			}
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
		
		// 아래의 static 메소드 호출하기
		printMember(list);
	}// main()
	
	// 회원목록을 콘솔창에 출력해주는 메소드
	public static void printMember(List<MemberDto> list) {
		for(MemberDto tmp : list) {
			System.out.println(tmp.getNum() + " | " + tmp.getName() + " | " + tmp.getAddr());
		}
	}
}

package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dao.MemberDao;
import test.util.DBConnect;
import test.util.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * 	Scanner 객체를 이용해서 문자열을 두 번 입력 받는다
		 * 	새로 추가 할 이름과 주소를 입력 받아서
		 * 	MemberDao 객체를 이용해서 DB에 저장하는 code를 작성하기
		 */
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
		dao.insert(dto);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문
			String sql = "SELECT num, name, addr FROM member" 
							+ " ORDER BY num ASC";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체를 이용해서 query문 수행하고 결과를
			// ResultSet 객체로 받아오기
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				// 출력하기
				System.out.println(num + " | " + name + " | " + addr);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

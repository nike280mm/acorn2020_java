package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 	2번 회원의
		 * 	이름을 말대
		 * 	주소를 연수동
		 * 	으로 수정하는 코드를 작성
		 */
		int num = 2;
		String name = "말대";
		String addr = "연수동";
		
		Connection conn = null;
		try{
			// 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속할 DB의 정보 @아이피주소: port번호: db이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// 예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공
			System.out.println("Oracle DB 접속 성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 필요한 객체의 참조값을 담을 빈 지역 변수 미리 만들기
		PreparedStatement pstmt = null;
		try {
			// 실행할 sql문
			String sql = "UPDATE member"
						+ " SET name = ?, addr = ?"
						+ " WHERE num = ?";
			// PreparedStataement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// ?에 값을 바인딩해서 미완성의 sql문을 완성시킨다
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, num);
			// 실제로 수행
			pstmt.executeUpdate();
			System.out.println("회원 정보를 변경했습니다");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				// 안전하게 마무리
				if(pstmt != null)pstmt.close();
			}catch (Exception e) {}
		}
	}
}

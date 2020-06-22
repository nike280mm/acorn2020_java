package test.main;

import test.dao.MemberDao;
import test.util.MemberDto;

public class MainClass10 {
	public static void main(String[] args) {
		// 만약 MemberDao 객체의 참조값이 필요하다면?
//		MemberDao dao = new MemberDao(); 직접 객체 생성 불가
		
		// static 메소드를 이용해서 MemberDao 객체의 참조값을 받아온다
		MemberDao dao = MemberDao.getInstance();
		// 새로 추가할 회원의 정보라면
		MemberDto dto = new MemberDto();
		dto.setName("마키");
		dto.setAddr("덕은리");
		// MemberDao 객체의 메소드를 활용해서 저장할 수 있다
		dao.insert(dto);
		
		dao.getData(101);
		
		dao.getList();
		
		MemberDao dao2 = MemberDao.getInstance();
		// 수정할 회원의 정보라면
		MemberDto dto2 = new MemberDto();
		dao2.update(dto2);
		
	}
}

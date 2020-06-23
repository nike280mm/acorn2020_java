package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.util.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * 	MemberDao 객체를 이용해서 회원목록을 얻어와
		 * 	아래와 같은 형식으로 출력하기
		 * 	num | name | addr
		 * 
		 */
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
		List<MemberDto> list = dao.getList();
		
		for(MemberDto tmp : list) {
			System.out.println(tmp.getNum() + " | " + tmp.getName() + " | " + tmp.getAddr());
		}
	}
}

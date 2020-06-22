package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.util.MemberDto;

public class Test {
	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
		int num = 1;
		String name = "허남영";
		String addr = "봉천동";
		
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		dao.update(dto);
	}
}

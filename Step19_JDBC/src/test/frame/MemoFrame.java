package test.frame;
/*
 * 	CREATE TABLE MEMO
 * 	(num NUMBER PRIMARY KEY, 
 * 	 content VARCHAR2(30), 
 * 	 regdate DATE);
 * 
 * 	CREATE SEQUENCE MEMO_SEQ;
 * 
 * 	위와 같이 테이블과 시퀀스를 만들고 해당 테이블에 데이터를 
 * 	SELECT, INSERT, UPDATE, DELETE 기능을 수행할 수 있는 MemoFrame을 만들기
 * 
 * 	조건
 * 	1. num 칼럼의 값은 시퀀스를 이용해서 넣기
 * 	2. regdate 칼럼(등록일)의 값은 SYSDATE를 이용하기
 * 	3. 수정은 content 만 수정가능하게 하기
 * 	4. MemoDto, MemoDao를 만들어서 프로그래밍 하기
 */
public class MemoFrame {

}

package test.main;
/*
 *  3. 비교연산자 테스트
<<<<<<< HEAD
 *  비교연산의 결과는 boolean type을 리턴해준다
=======
 *     비교연산의 결과는 boolean type 을 리턴해준다. 
>>>>>>> refs/remotes/upstream/master
 *  ==, !=, >, >=, <, <= 
 */
public class MainClass03 {
	public static void main(String[] args) {
		
		boolean result1 = 10 == 10; //true
		boolean result2 = 10 != 10; //false
		boolean result3 = 10 > 100; //false;
		boolean result4 = 10 >= 10; //true
		boolean result5 = 10 < 100; //true
		boolean result6 = 10 <= 10; //true	
<<<<<<< HEAD
		// Sting type 변수 name에 null 대입하기
=======
		
		// String type 변수 name 에 null 대입하기 
>>>>>>> refs/remotes/upstream/master
		String name=null;
		
<<<<<<< HEAD
		// null인지 아닌지 비교가 가능하다 (java에서 null값은 비교가 가능)
=======
		// null 인지 아닌지 비교가 가능하다 (즉 java 에서 null 값은 비교가 가능)
>>>>>>> refs/remotes/upstream/master
		boolean result7 = name == null; //true
		boolean result8 = name != null; //false
	}
}
package test.main;

import test.mypac.Zoo;

import test.mypac.Zoo.Monkey;
import test.mypac.Zoo.Tiger;

public class MainClass03 {
	public static void main(String[] args) {
		
		Zoo z = new Zoo();
		
		Monkey m1 = z.getMonkey();
		
		Tiger t1 = z.getTiger();
		
		m1.say();
		
		t1.say();
	}
}

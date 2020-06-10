package test.main;

import javax.swing.JFrame;

public class MainClass06 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("뭐");
		// 창의 위치와 폭과 높이
		jf.setBounds(700, 300, 500, 500);
		// 창이 화면상에 보이도록 한다
		jf.setVisible(true);
		// 창을 닫을 때 프로세스도 자동으로 종료되도록 한다
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

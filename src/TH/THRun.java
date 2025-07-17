package TH;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class THRun {

	private JFrame frame;
	public static void main(String[] args) {
		new THRun();
	}
	public THRun() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("메뉴 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.setVisible(true);
		
	}

}

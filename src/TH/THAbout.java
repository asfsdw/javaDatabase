package TH;

import javax.swing.JFrame;

public class THAbout {
	private JFrame frame;
	public THAbout() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		
		
	}
}

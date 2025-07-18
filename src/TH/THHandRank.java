package TH;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class THHandRank {
	private JFrame frame;
	public THHandRank() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("족보 확인");
		frame.setBounds(0, 0, 800, 600);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHandRank = new JLabel("");
		lblHandRank.setIcon(new ImageIcon(THHandRank.class.getResource("/TH/images/lblHandRank.jpg")));
		lblHandRank.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblHandRank);

		frame.setVisible(true);
	}
}

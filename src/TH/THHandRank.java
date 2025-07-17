package TH;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class THHandRank {
	private JFrame frame;
	public THHandRank() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("족보 확인");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReturn = new JButton("돌아가기");
		btnReturn.setBounds(320, 430, 118, 46);
		frame.getContentPane().add(btnReturn);
		
		JLabel lblHandRank = new JLabel("");
		lblHandRank.setIcon(new ImageIcon(THHandRank.class.getResource("/TH/images/lblHandRank.jpg")));
		lblHandRank.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblHandRank);

		frame.setVisible(true);
		
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THRun();
			}
		});
	}
}

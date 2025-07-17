package TH;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setTitle("텍사스 홀뎀");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("게임시작");
		btnStart.setFont(new Font("굴림", Font.BOLD, 20));
		btnStart.setBounds(53, 463, 129, 60);
		frame.getContentPane().add(btnStart);
		
		JButton btnAbout = new JButton("게임설명");
		btnAbout.setFont(new Font("굴림", Font.BOLD, 20));
		btnAbout.setBounds(235, 463, 129, 60);
		frame.getContentPane().add(btnAbout);
		
		JButton btnHandRank = new JButton("족보보기");
		btnHandRank.setFont(new Font("굴림", Font.BOLD, 20));
		btnHandRank.setBounds(417, 463, 129, 60);
		frame.getContentPane().add(btnHandRank);
		
		JButton btnExit = new JButton("게임종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(599, 463, 129, 60);
		frame.getContentPane().add(btnExit);
		
		JLabel lblTitleImage = new JLabel("");
		lblTitleImage.setIcon(new ImageIcon(THRun.class.getResource("/TH/images/lblTitleImage.jpg")));
		lblTitleImage.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblTitleImage);
		
		frame.setVisible(true);
		
//		게임설명
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THAbout();
			}
		});
//		족보설명
		btnHandRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THHandRank();
			}
		});
//		게임종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "게임을 종료하시겠습니까?","게임종료",JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
	}
}

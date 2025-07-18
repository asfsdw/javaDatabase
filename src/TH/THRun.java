package TH;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class THRun extends THDAO {
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
		btnStart.setBounds(99, 463, 129, 60);
		frame.getContentPane().add(btnStart);
		
		JButton btnHandRank = new JButton("족보보기");
		btnHandRank.setFont(new Font("굴림", Font.BOLD, 20));
		btnHandRank.setBounds(327, 463, 129, 60);
		frame.getContentPane().add(btnHandRank);
		
		JButton btnExit = new JButton("게임종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(555, 463, 129, 60);
		frame.getContentPane().add(btnExit);
		
		JLabel lblTitleImage = new JLabel("");
		lblTitleImage.setIcon(new ImageIcon(THRun.class.getResource("/TH/images/lblTitleImage.jpg")));
		lblTitleImage.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblTitleImage);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmHandRank = new JMenuItem("족보보기");
		mnFile.add(mntmHandRank);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("종료");
		mnFile.add(mntmExit);
		
		frame.setVisible(true);
		
//		게임시작
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THAcountSelect();
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 0) {
					frame.dispose();
					new THGameStart();
				}
			}
		});
		
//		족보보기
		btnHandRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new THHandRank();
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 0) new THHandRank();
			}
		});
		
//		메뉴바 족보보기
		mntmHandRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnExit.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 0) {
					int ans = JOptionPane.showConfirmDialog(frame, "게임을 종료하시겠습니까?","게임종료",JOptionPane.YES_NO_OPTION);
					if (ans == 0) System.exit(0);
				}
			}
		});
		
//		메뉴바 게임종료
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "게임을 종료하시겠습니까?","게임종료",JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
	}
}

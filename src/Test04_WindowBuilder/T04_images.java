package Test04_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class T04_images {
	JLabel lblMessage;
	JLabel lblImage1,lblImage2,lblImage3,lblImage4;
	
	int img1Cnt1 = 0,img1Cnt2 = 0,img1Cnt3 = 0,img1Cnt4 = 0;
	
	private JFrame frame;
	public static void main(String[] args) {
		new T04_images();
	}
	public T04_images() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("카드횟수 맞추기");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 960, 66);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JButton btn1 = new JButton("모두보기");
		btn1.setFont(new Font("굴림", Font.BOLD, 18));
		btn1.setBounds(11, 10, 107, 46);
		pn1.add(btn1);
		
		JButton btn2 = new JButton("1번보기");
		btn2.setFont(new Font("굴림", Font.BOLD, 18));
		btn2.setBounds(129, 10, 107, 46);
		pn1.add(btn2);
		
		JButton btn3 = new JButton("2번보기");
		btn3.setFont(new Font("굴림", Font.BOLD, 18));
		btn3.setBounds(247, 10, 107, 46);
		pn1.add(btn3);
		
		JButton btn4 = new JButton("3번보기");
		btn4.setFont(new Font("굴림", Font.BOLD, 18));
		btn4.setBounds(365, 10, 107, 46);
		pn1.add(btn4);
		
		JButton btn5 = new JButton("4번보기");
		btn5.setFont(new Font("굴림", Font.BOLD, 18));
		btn5.setBounds(483, 10, 107, 46);
		pn1.add(btn5);
		
		JButton btn6 = new JButton("랜덤보기");
		btn6.setFont(new Font("굴림", Font.BOLD, 18));
		btn6.setBounds(601, 10, 107, 46);
		pn1.add(btn6);
		
		JButton btnClose = new JButton("모두닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 18));
		btnClose.setBounds(719, 10, 107, 46);
		pn1.add(btnClose);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(837, 10, 107, 46);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 86, 960, 389);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage1 = new JLabel("");
		lblImage1.setIcon(new ImageIcon(T04_images.class.getResource("/Test04_WindowBuilder/images/01.png")));
		lblImage1.setBounds(4, 10, 234, 369);
		pn2.add(lblImage1);
		
		lblImage2 = new JLabel("");
		lblImage2.setIcon(new ImageIcon(T04_images.class.getResource("/Test04_WindowBuilder/images/03.png")));
		lblImage2.setBounds(242, 10, 234, 369);
		pn2.add(lblImage2);
		
		lblImage3 = new JLabel("");
		lblImage3.setIcon(new ImageIcon(T04_images.class.getResource("/Test04_WindowBuilder/images/05.png")));
		lblImage3.setBounds(480, 10, 234, 369);
		pn2.add(lblImage3);
		
		lblImage4 = new JLabel("");
		lblImage4.setIcon(new ImageIcon(T04_images.class.getResource("/Test04_WindowBuilder/images/06.jpg")));
		lblImage4.setBounds(718, 10, 234, 369);
		pn2.add(lblImage4);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 485, 960, 66);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		lblMessage = new JLabel("선택된 카드의 횟수를 보여줍니다.");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("굴림", Font.BOLD, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 10, 936, 46);
		pn3.add(lblMessage);
		
		frame.setVisible(true);
		
//		종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료하겠습니까?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
		
//		모두보기 버튼
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDisplay();
				img1Cnt1++;
				img1Cnt2++;
				img1Cnt3++;
				img1Cnt4++;
				displayCount();
			}
		});
		
//		모두닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				img1Cnt1 = 0;
				img1Cnt2 = 0;
				img1Cnt3 = 0;
				img1Cnt4 = 0;
				displayCount();
			}
		});
		
//		1번보기 버튼
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				lblImage1.setVisible(true);
				img1Cnt1++;
				displayCount();
			}
		});
		
//		2번보기 버튼
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				lblImage2.setVisible(true);
				img1Cnt2++;
				displayCount();
			}
		});
		
//		3번보기 버튼
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				lblImage3.setVisible(true);
				img1Cnt3++;
				displayCount();
			}
		});
		
//		4번보기 버튼
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				lblImage4.setVisible(true);
				img1Cnt4++;
				displayCount();
			}
		});
		
//		랜덤보기
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand = (int)(Math.random()*4)+1;
				allClose();
				if(rand == 1) {
					lblImage1.setVisible(true);
					img1Cnt1++;
				}
				else if(rand == 2) {
					lblImage2.setVisible(true);
					img1Cnt2++;
				}
				else if(rand == 3) {
					lblImage3.setVisible(true);
					img1Cnt3++;
				}
				else if(rand == 4) {
					lblImage4.setVisible(true);
					img1Cnt4++;
				}
				displayCount();
			}
		});
	}
	
//	카운트 수를 레이블에 출력
	protected void displayCount() {
		lblMessage.setText("1번 : "+img1Cnt1+", 2번 : "+img1Cnt2+", 3번 : "+img1Cnt3+", 4번 : "+img1Cnt4);
	}
	protected void allDisplay() {
		lblImage1.setVisible(true);
		lblImage2.setVisible(true);
		lblImage3.setVisible(true);
		lblImage4.setVisible(true);
	}
	protected void allClose() {
		lblImage1.setVisible(false);
		lblImage2.setVisible(false);
		lblImage3.setVisible(false);
		lblImage4.setVisible(false);
	}
}

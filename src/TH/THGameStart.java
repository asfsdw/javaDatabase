package TH;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class THGameStart {
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	THService service = new THService();
	THVO vo = new THVO();
	THDAO dao = new THDAO();
	
	int cnt = 0;

	public THGameStart() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setTitle("텍사스 홀뎀");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		service.cardDealStart();
		
		JLabel lblCpu11 = new JLabel("");
		lblCpu11.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu11.setBounds(19, 156, 90, 120);
		frame.getContentPane().add(lblCpu11);
		
		JLabel lblCpu12 = new JLabel("");
		lblCpu12.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu12.setBounds(19, 286, 90, 120);
		frame.getContentPane().add(lblCpu12);
		
		JLabel lblCpu21 = new JLabel("");
		lblCpu21.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu21.setBounds(280, 10, 90, 120);
		lblCpu21.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblCpu21);
		
		JLabel lblCpu22 = new JLabel("");
		lblCpu22.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu22.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu22.setBounds(382, 10, 90, 120);
		frame.getContentPane().add(lblCpu22);
		
		JLabel lblCpu31 = new JLabel("");
		lblCpu31.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu31.setBounds(682, 156, 90, 120);
		frame.getContentPane().add(lblCpu31);
		
		JLabel lblCpu32 = new JLabel("");
		lblCpu32.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu32.setBounds(682, 286, 90, 120);
		frame.getContentPane().add(lblCpu32);
		
		JLabel lblPL1 = new JLabel("");
		lblPL1.setIcon(new ImageIcon(getClass().getResource(service.getPlHand1().getImagePath())));
		lblPL1.setBounds(280, 431, 90, 120);
		lblPL1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblPL1);
		
		JLabel lblPL2 = new JLabel("");
		lblPL2.setIcon(new ImageIcon(getClass().getResource(service.getPlHand2().getImagePath())));
		lblPL2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPL2.setBounds(382, 431, 90, 120);
		frame.getContentPane().add(lblPL2);
		
		JLabel lblField1 = new JLabel("");
		lblField1.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField1.setBounds(128, 220, 90, 120);
		frame.getContentPane().add(lblField1);
		
		JLabel lblField2 = new JLabel("");
		lblField2.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField2.setBounds(237, 220, 90, 120);
		frame.getContentPane().add(lblField2);
		
		JLabel lblField3 = new JLabel("");
		lblField3.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField3.setBounds(346, 220, 90, 120);
		frame.getContentPane().add(lblField3);
		
		JLabel lblField4 = new JLabel("");
		lblField4.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField4.setBounds(455, 220, 90, 120);
		frame.getContentPane().add(lblField4);
		
		JLabel lblField5 = new JLabel("");
		lblField5.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField5.setBounds(564, 220, 90, 120);
		frame.getContentPane().add(lblField5);
		
		JRadioButton rdRaise = new JRadioButton("레이즈");
		rdRaise.setBackground(Color.WHITE);
		buttonGroup.add(rdRaise);
		rdRaise.setFont(new Font("굴림", Font.BOLD, 15));
		rdRaise.setForeground(Color.RED);
		rdRaise.setBounds(564, 402, 90, 33);
		frame.getContentPane().add(rdRaise);
		
		JRadioButton rdCall = new JRadioButton("콜");
		rdCall.setBackground(Color.WHITE);
		buttonGroup.add(rdCall);
		rdCall.setForeground(Color.BLACK);
		rdCall.setFont(new Font("굴림", Font.BOLD, 15));
		rdCall.setBounds(564, 437, 90, 33);
		frame.getContentPane().add(rdCall);
		
		JRadioButton rdFold = new JRadioButton("폴드");
		rdFold.setBackground(Color.WHITE);
		buttonGroup.add(rdFold);
		rdFold.setForeground(Color.GRAY);
		rdFold.setFont(new Font("굴림", Font.BOLD, 15));
		rdFold.setBounds(564, 472, 90, 33);
		frame.getContentPane().add(rdFold);
		
		JLabel lblFieldPoint = new JLabel("판돈");
		lblFieldPoint.setBackground(Color.WHITE);
		lblFieldPoint.setFont(new Font("굴림", Font.BOLD, 20));
		lblFieldPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblFieldPoint.setBounds(296, 167, 151, 43);
		frame.getContentPane().add(lblFieldPoint);
		
		JLabel lblPlPoint = new JLabel("현재 포인트");
		lblPlPoint.setBackground(Color.WHITE);
		lblPlPoint.setFont(new Font("굴림", Font.BOLD, 15));
		lblPlPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlPoint.setBounds(564, 363, 90, 33);
		frame.getContentPane().add(lblPlPoint);
		
		JButton btnAction = new JButton("선택");
		btnAction.setBackground(Color.WHITE);
		btnAction.setFont(new Font("굴림", Font.BOLD, 15));
		btnAction.setBounds(564, 511, 90, 40);
		frame.getContentPane().add(btnAction);
		
		JLabel lblTrun = new JLabel("액션을 선택해주세요.");
		lblTrun.setBackground(Color.WHITE);
		lblTrun.setFont(new Font("굴림", Font.BOLD, 20));
		lblTrun.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrun.setBounds(176, 362, 369, 43);
		frame.getContentPane().add(lblTrun);
		
		frame.setVisible(true);
		
//		라디오버튼 레이즈
		rdRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String about = "";
				about = "판돈의 2배만큼 포인트를 배팅합니다.";
				lblTrun.setText(about);
			}
		});
//		라디오버튼 콜
		rdCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String about = "";
				about = "판돈과 같은 포인트를 배팅합니다.";
				lblTrun.setText(about);
			}
		});
//		라디오버튼 폴드
		rdFold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String about = "";
				about = "이번 판을 포기합니다.";
				lblTrun.setText(about);
			}
		});
		
//		액션 선택
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdRaise.isSelected()) {
					dao.Raise();
					cnt++;
				}
			}
		});
	}
}

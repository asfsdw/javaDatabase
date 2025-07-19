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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class THGameStart {
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	THService service = new THService();
	THVO vo = new THVO();
	THDAO dao = new THDAO();
	
	private JLabel lblPL1, lblPL2, lblCpu11, lblCpu12, lblCpu21, lblCpu22, lblCpu31, lblCpu32;
  private JLabel lblField1, lblField2, lblField3, lblField4, lblField5;
  private JLabel lblTrun;
  private JLabel lblFieldPoint, lblCpu1Point, lblCpu2Point, lblCpu3Point, lblPlPoint;
  
  JRadioButton rdRaise, rdCall, rdFold;
  JButton btnAction;
  
	int plCnt = 0, gameCnt = 0, point = 0,
			cpu1Point = 10000, cpu2Point = 10000, cpu3Point = 10000;
	String name = "", about = "";
	boolean cpu1 = true,  cpu2 = true, cpu3 = true, cpu1Fold = false, cpu2Fold = false, cpu3Fold = false;

	public THGameStart(String name, int point) {
		this.name = name;
		this.point = point;
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
		
		lblCpu11 = new JLabel("");
		lblCpu11.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu11.setBounds(19, 140, 90, 120);
		frame.getContentPane().add(lblCpu11);
		
		lblCpu12 = new JLabel("");
		lblCpu12.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu12.setBounds(19, 270, 90, 120);
		frame.getContentPane().add(lblCpu12);
		
		lblCpu21 = new JLabel("");
		lblCpu21.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu21.setBounds(280, 10, 90, 120);
		lblCpu21.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblCpu21);
		
		lblCpu22 = new JLabel("");
		lblCpu22.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu22.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu22.setBounds(382, 10, 90, 120);
		frame.getContentPane().add(lblCpu22);
		
		lblCpu31 = new JLabel("");
		lblCpu31.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu31.setBounds(682, 140, 90, 120);
		frame.getContentPane().add(lblCpu31);
		
		lblCpu32 = new JLabel("");
		lblCpu32.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu32.setBounds(682, 270, 90, 120);
		frame.getContentPane().add(lblCpu32);
		
		lblPL1 = new JLabel("");
		lblPL1.setIcon(new ImageIcon(getClass().getResource(service.getPlHand1().getImagePath())));
		lblPL1.setBounds(280, 431, 90, 120);
		lblPL1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblPL1);
		
		lblPL2 = new JLabel("");
		lblPL2.setIcon(new ImageIcon(getClass().getResource(service.getPlHand2().getImagePath())));
		lblPL2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPL2.setBounds(382, 431, 90, 120);
		frame.getContentPane().add(lblPL2);
		
		lblField1 = new JLabel("");
		lblField1.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField1.setBounds(128, 204, 90, 120);
		frame.getContentPane().add(lblField1);
		
		lblField2 = new JLabel("");
		lblField2.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField2.setBounds(237, 204, 90, 120);
		frame.getContentPane().add(lblField2);
		
		lblField3 = new JLabel("");
		lblField3.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField3.setBounds(346, 204, 90, 120);
		frame.getContentPane().add(lblField3);
		
		lblField4 = new JLabel("");
		lblField4.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField4.setBounds(455, 204, 90, 120);
		frame.getContentPane().add(lblField4);
		
		lblField5 = new JLabel("");
		lblField5.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField5.setBounds(564, 204, 90, 120);
		frame.getContentPane().add(lblField5);
		
		rdRaise = new JRadioButton("레이즈");
		rdRaise.setBackground(Color.WHITE);
		buttonGroup.add(rdRaise);
		rdRaise.setFont(new Font("굴림", Font.BOLD, 15));
		rdRaise.setForeground(Color.RED);
		rdRaise.setBounds(564, 386, 90, 33);
		frame.getContentPane().add(rdRaise);
		
		rdCall = new JRadioButton("콜");
		rdCall.setBackground(Color.WHITE);
		buttonGroup.add(rdCall);
		rdCall.setForeground(Color.BLACK);
		rdCall.setFont(new Font("굴림", Font.BOLD, 15));
		rdCall.setBounds(564, 421, 90, 33);
		frame.getContentPane().add(rdCall);
		
		rdFold = new JRadioButton("폴드");
		rdFold.setBackground(Color.WHITE);
		buttonGroup.add(rdFold);
		rdFold.setForeground(Color.GRAY);
		rdFold.setFont(new Font("굴림", Font.BOLD, 15));
		rdFold.setBounds(564, 456, 90, 33);
		frame.getContentPane().add(rdFold);
		
		lblFieldPoint = new JLabel(dao.fieldMoney+"");
		lblFieldPoint.setBackground(Color.WHITE);
		lblFieldPoint.setFont(new Font("굴림", Font.BOLD, 20));
		lblFieldPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblFieldPoint.setBounds(296, 151, 151, 43);
		frame.getContentPane().add(lblFieldPoint);
		
		lblPlPoint = new JLabel(point+"");
		lblPlPoint.setBackground(Color.WHITE);
		lblPlPoint.setFont(new Font("굴림", Font.BOLD, 15));
		lblPlPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlPoint.setBounds(564, 347, 90, 33);
		frame.getContentPane().add(lblPlPoint);
		
		btnAction = new JButton("선택");
		btnAction.setBackground(Color.WHITE);
		btnAction.setFont(new Font("굴림", Font.BOLD, 15));
		btnAction.setBounds(564, 495, 90, 40);
		frame.getContentPane().add(btnAction);
		
		lblTrun = new JLabel("액션을 선택해주세요.");
		lblTrun.setBackground(Color.WHITE);
		lblTrun.setFont(new Font("굴림", Font.BOLD, 20));
		lblTrun.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrun.setBounds(128, 346, 436, 43);
		frame.getContentPane().add(lblTrun);
		
		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 482, 105, 53);
		frame.getContentPane().add(lblNewLabel);
		
		lblCpu1Point = new JLabel(cpu1Point+"");
		lblCpu1Point.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu1Point.setFont(new Font("굴림", Font.BOLD, 15));
		lblCpu1Point.setBackground(Color.WHITE);
		lblCpu1Point.setBounds(19, 97, 90, 33);
		frame.getContentPane().add(lblCpu1Point);
		
		lblCpu2Point = new JLabel(cpu2Point+"");
		lblCpu2Point.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu2Point.setFont(new Font("굴림", Font.BOLD, 15));
		lblCpu2Point.setBackground(Color.WHITE);
		lblCpu2Point.setBounds(484, 10, 90, 33);
		frame.getContentPane().add(lblCpu2Point);
		
		lblCpu3Point = new JLabel(cpu3Point+"");
		lblCpu3Point.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu3Point.setFont(new Font("굴림", Font.BOLD, 15));
		lblCpu3Point.setBackground(Color.WHITE);
		lblCpu3Point.setBounds(682, 97, 90, 33);
		frame.getContentPane().add(lblCpu3Point);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmHandRank = new JMenuItem("족보보기");
		mnNewMenu.add(mntmHandRank);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("게임종료");
		mnNewMenu.add(mntmExit);
		
//		판돈만큼 포인트 차감
		point -= dao.originFieldMoney;
		cpu1Point -= dao.originFieldMoney;
		cpu2Point -= dao.originFieldMoney;
		cpu3Point -= dao.originFieldMoney;
		lblPlPoint.setText(point+"");
		lblCpu1Point.setText(cpu1Point+"");
		lblCpu2Point.setText(cpu2Point+"");
		lblCpu3Point.setText(cpu3Point+"");
		frame.repaint();
//		차감한만큼 판돈 추가
		dao.fieldMoney += dao.originFieldMoney*4;
		lblFieldPoint.setText(dao.fieldMoney+"");
		frame.setVisible(true);
		frame.repaint();
		
//		라디오버튼 레이즈
		rdRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = "";
				about = "판돈의 2배만큼 포인트를 배팅합니다.";
				lblTrun.setText(about);
			}
		});
//		라디오버튼 콜
		rdCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = "";
				about = "판돈과 같은 포인트를 배팅합니다.";
				lblTrun.setText(about);
			}
		});
//		라디오버튼 폴드
		rdFold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = "";
				about = "이번 판을 포기합니다.";
				lblTrun.setText(about);
			}
		});
		
//		액션 선택
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdRaise.isSelected()) {
					point = dao.Raise(name);
					lblFieldPoint.setText(dao.fieldMoney+"");
					lblPlPoint.setText(point+"");
					plCnt++;
					frame.repaint();
					rdRaise.setEnabled(false);
					rdCall.setEnabled(false);
					rdFold.setEnabled(false);
					btnAction.setEnabled(false);
					cpu1Action();
				}
				else if(rdCall.isSelected()) {
					point = dao.Call(name);
					lblFieldPoint.setText(dao.fieldMoney+"");
					lblPlPoint.setText(point+"");
					plCnt++;
					frame.repaint();
					rdRaise.setEnabled(false);
					rdCall.setEnabled(false);
					rdFold.setEnabled(false);
					btnAction.setEnabled(false);
					cpu1Action();
				}
				else if(rdFold.isSelected()) {
					lblTrun.setText(about);
					gameCnt++;
					frame.repaint();
					rdRaise.setEnabled(false);
					rdCall.setEnabled(false);
					rdFold.setEnabled(false);
					btnAction.setEnabled(false);
					showDown();
				}
			}
		});
		
//		메뉴바 족보보기
		mntmHandRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new THHandRank();
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
	
	private void cpu1Action() {
//		cpu1액션 선택
		if(cpu1 == true && plCnt == 1) {
			int action = 0;
			action = (int)(Math.random()*20);
			if(action <= 5) {
				about = "CPU1이 Fold를 선택했습니다.";
				lblTrun.setText(about);
				plCnt++;
				cpu1Fold = true;
				cpu1 = false;
			}
			else if(action <= 15) {
				about = "CPU1이 Call을 선택했습니다.";
				lblTrun.setText(about);
				cpu1Point -= dao.fieldMoney;
				lblCpu1Point.setText(cpu1Point+"");
				plCnt++;
			}
			else {
				about = "CPU1이 Raise를 선택했습니다";
				lblTrun.setText(about);
				cpu1Point -= dao.fieldMoney*2;
				lblCpu1Point.setText(cpu1Point+"");
				plCnt++;
			}
			frame.repaint();
		}
		else {
			plCnt++;
			frame.repaint();
			cpu2Action();
		}
//			swing 딜레이 메소드
		new javax.swing.Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((javax.swing.Timer)e.getSource()).stop();
				cpu2Action();
			}
		}).start();
	}
	private void cpu2Action() {
//		cpu2액션 선택
		if(cpu2 == true && plCnt == 2) {
			int action = 0;
			action = (int)(Math.random()*20);
			if(action <= 5) {
				about = "CPU2이 Fold를 선택했습니다.";
				lblTrun.setText(about);
				plCnt++;
				cpu2Fold = true;
				cpu2 = false;
			}
			else if(action <= 15) {
				about = "CPU2이 Call을 선택했습니다.";
				lblTrun.setText(about);
				cpu2Point -= dao.fieldMoney;
				lblCpu2Point.setText(cpu2Point+"");
				plCnt++;
			}
			else {
				about = "CPU2이 Raise를 선택했습니다.";
				lblTrun.setText(about);
				cpu2Point -= dao.fieldMoney*2;
				lblCpu2Point.setText(cpu2Point+"");
				plCnt++;
			}
			frame.repaint();
		}
		else {
			plCnt++;
			frame.repaint();
			cpu3Action();
		}
		new javax.swing.Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((javax.swing.Timer)e.getSource()).stop();
				cpu3Action();
			}
		}).start();
	}
	private void cpu3Action() {
//		cpu3액션 선택
		if(cpu3 == true && plCnt == 3) {
			int action = 0;
			action = (int)(Math.random()*20);
			if(action <= 5) {
				about = "CPU3이 Fold를 선택했습니다.";
				lblTrun.setText(about);
				plCnt = 0;
				gameCnt++;
				frame.repaint();
				rdRaise.setEnabled(true);
				rdCall.setEnabled(true);
				rdFold.setEnabled(true);
				btnAction.setEnabled(true);
				cpu3Fold = true;
				cpu3 = false;
			}
			else if(action <= 15) {
				about = "CPU3이 Call을 선택했습니다.";
				lblTrun.setText(about);
				cpu3Point -= dao.fieldMoney;
				lblCpu3Point.setText(cpu3Point+"");
				plCnt = 0;
				gameCnt++;
				frame.repaint();
				rdRaise.setEnabled(true);
				rdCall.setEnabled(true);
				rdFold.setEnabled(true);
				btnAction.setEnabled(true);
			}
			else {
				about = "CPU3이 Raise를 선택했습니다.";
				lblTrun.setText(about);
				cpu3Point -= dao.fieldMoney*2;
				lblCpu3Point.setText(cpu3Point+"");
				plCnt = 0;
				gameCnt++;
				frame.repaint();
				rdRaise.setEnabled(true);
				rdCall.setEnabled(true);
				rdFold.setEnabled(true);
				btnAction.setEnabled(true);
			}
		}
		else {
			about = "CPU3은 Fold상태 입니다.";
			lblTrun.setText(about);
			plCnt = 0;
			gameCnt++;
			frame.repaint();
			rdRaise.setEnabled(true);
			rdCall.setEnabled(true);
			rdFold.setEnabled(true);
			btnAction.setEnabled(true);
		}
		if(cpu1Fold == true && cpu2Fold == true && cpu3Fold == true) showDown();
		else fieldFlip();
	}
	
	private void fieldFlip() {
		if(gameCnt == 1) {
			lblField1.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField1().getImagePath())));
			lblField2.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField2().getImagePath())));
			lblField3.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField3().getImagePath())));
			frame.repaint();
		}
		else if(gameCnt == 2) {
			lblField4.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField4().getImagePath())));
			frame.repaint();
		}
		else if(gameCnt == 3) {
			lblField5.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField5().getImagePath())));
			frame.repaint();
		}
		else if(gameCnt == 4) {
			showDown();
		}
	}

	private String showDown() {
		String res = "";

		cpu1 = true;
		cpu2 = true;
		cpu3 = true;
		
		rdRaise.setEnabled(false);
		rdCall.setEnabled(false);
		rdFold.setEnabled(false);
		btnAction.setEnabled(false);
		
		lblCpu11.setIcon(new ImageIcon(THGameStart.class.getResource(service.getCpu1Hand1().getImagePath())));
		lblCpu12.setIcon(new ImageIcon(THGameStart.class.getResource(service.getCpu1Hand2().getImagePath())));
		lblCpu21.setIcon(new ImageIcon(THGameStart.class.getResource(service.getCpu2Hand1().getImagePath())));
		lblCpu22.setIcon(new ImageIcon(THGameStart.class.getResource(service.getCpu2Hand2().getImagePath())));
		lblCpu31.setIcon(new ImageIcon(THGameStart.class.getResource(service.getCpu3Hand1().getImagePath())));
		lblCpu32.setIcon(new ImageIcon(THGameStart.class.getResource(service.getCpu3Hand2().getImagePath())));
		lblField1.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField1().getImagePath())));
		lblField2.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField2().getImagePath())));
		lblField3.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField3().getImagePath())));
		lblField4.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField4().getImagePath())));
		lblField5.setIcon(new ImageIcon(THGameStart.class.getResource(service.getField5().getImagePath())));
		frame.repaint();
		double plHandrank = service.handRank(service.getPlHand1().getCard(), service.getPlHand2().getCard(), service.getField1().getCard(),service.getField2().getCard(),service.getField3().getCard(),service.getField4().getCard(),service.getField5().getCard());
		double cpu1Handrank = service.handRank(service.getCpu1Hand1().getCard(), service.getCpu1Hand2().getCard(), service.getField1().getCard(),service.getField2().getCard(),service.getField3().getCard(),service.getField4().getCard(),service.getField5().getCard());
		double cpu2Handrank = service.handRank(service.getCpu2Hand1().getCard(), service.getCpu2Hand2().getCard(), service.getField1().getCard(),service.getField2().getCard(),service.getField3().getCard(),service.getField4().getCard(),service.getField5().getCard());
		double cpu3Handrank = service.handRank(service.getCpu3Hand1().getCard(), service.getCpu3Hand2().getCard(), service.getField1().getCard(),service.getField2().getCard(),service.getField3().getCard(),service.getField4().getCard(),service.getField5().getCard());
		if(rdFold.isSelected()) plHandrank = 0.0;
		if(cpu1Fold) cpu1Handrank = 0.0; cpu1Fold = false;
		if(cpu2Fold) cpu2Handrank = 0.0; cpu2Fold = false;
		if(cpu3Fold) cpu3Handrank = 0.0; cpu3Fold = false;
		
		if(plHandrank >= cpu1Handrank && plHandrank >= cpu2Handrank && plHandrank >= cpu3Handrank) {
			if(plHandrank == 1000.0) res = "당신이 로열 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 900.0) res = "당신이 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 800.0) res = "당신이 포카드로 승리했습니다!";
			else if(plHandrank == 700.0) res = "당신이 풀하우스로 승리했습니다!";
			else if(plHandrank == 600.0) res = "당신이 플러쉬로 승리했습니다!";
			else if(plHandrank == 500.0) res = "당신이 스트레이트탑으로 승리했습니다!";
			else if(plHandrank == 400.0) res = "당신이 스트레이트로 승리했습니다!";
			else if(plHandrank == 300.0) res = "당신이 트리플로 승리했습니다!";
			else if(plHandrank == 200.0) res = "당신이 투페어로 승리했습니다!";
			else if(plHandrank == 100.0) res = "당신이 원페어로 승리했습니다!";
			else res = "당신이 하이카드로 승리했습니다!";
			lblTrun.setText(res);
			point = dao.pointResult(name);
			if(cpu1Point < 0 || cpu2Point < 0 || cpu3Point < 0) {
				JOptionPane.showConfirmDialog(frame, "당신이 게임에서 승리했습니다!","돌아가기",JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				new THAccountSelect();
				return res;
			}
		}
		else if(cpu1Handrank > plHandrank && cpu1Handrank > cpu2Handrank && cpu1Handrank > cpu3Handrank) {
			if(plHandrank == 1000.0) res = "CPU1이 로열 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 900.0) res = "CPU1이 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 800.0) res = "CPU1이 포카드로 승리했습니다!";
			else if(plHandrank == 700.0) res = "CPU1이 풀하우스로 승리했습니다!";
			else if(plHandrank == 600.0) res = "CPU1이 플러쉬로 승리했습니다!";
			else if(plHandrank == 500.0) res = "CPU1이 스트레이트탑으로 승리했습니다!";
			else if(plHandrank == 400.0) res = "CPU1이 스트레이트로 승리했습니다!";
			else if(plHandrank == 300.0) res = "CPU1이 트리플로 승리했습니다!";
			else if(plHandrank == 200.0) res = "CPU1이 투페어로 승리했습니다!";
			else if(plHandrank == 100.0) res = "CPU1이 원페어로 승리했습니다!";
			else res = "CPU1이 하이카드로 승리했습니다!";
			lblTrun.setText(res);
			cpu1Point += dao.fieldMoney;
			if(point < 0 || cpu2Point < 0 || cpu3Point < 0) {
				JOptionPane.showConfirmDialog(frame, "CPU1이 게임에서 승리했습니다!","돌아가기",JOptionPane.WARNING_MESSAGE);
				frame.dispose();
				new THAccountSelect();
				return res;
			}
		}
		else if(cpu2Handrank > plHandrank && cpu2Handrank > cpu1Handrank && cpu2Handrank > cpu3Handrank) {
			if(plHandrank == 1000.0) res = "CPU2가 로열 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 900.0) res = "CPU2가 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 800.0) res = "CPU2가 포카드로 승리했습니다!";
			else if(plHandrank == 700.0) res = "CPU2가 풀하우스로 승리했습니다!";
			else if(plHandrank == 600.0) res = "CPU2가 플러쉬로 승리했습니다!";
			else if(plHandrank == 500.0) res = "CPU2가 스트레이트탑으로 승리했습니다!";
			else if(plHandrank == 400.0) res = "CPU2가 스트레이트로 승리했습니다!";
			else if(plHandrank == 300.0) res = "CPU2가 트리플로 승리했습니다!";
			else if(plHandrank == 200.0) res = "CPU2가 투페어로 승리했습니다!";
			else if(plHandrank == 100.0) res = "CPU2가 원페어로 승리했습니다!";
			else res = "CPU2가 하이카드로 승리했습니다!";
			lblTrun.setText(res);
			cpu2Point += dao.fieldMoney;
			if(point < 0 || cpu1Point < 0 || cpu3Point < 0) {
				JOptionPane.showConfirmDialog(frame, "CPU2이 게임에서 승리했습니다!","돌아가기",JOptionPane.WARNING_MESSAGE);
				frame.dispose();
				new THAccountSelect();
				return res;
			}
		}
		else {
			if(plHandrank == 1000.0) res = "CPU3이 로열 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 900.0) res = "CPU3이 스트레이트 플러쉬로 승리했습니다!";
			else if(plHandrank == 800.0) res = "CPU3이 포카드로 승리했습니다!";
			else if(plHandrank == 700.0) res = "CPU3이 풀하우스로 승리했습니다!";
			else if(plHandrank == 600.0) res = "CPU3이 플러쉬로 승리했습니다!";
			else if(plHandrank == 500.0) res = "CPU3이 스트레이트탑으로 승리했습니다!";
			else if(plHandrank == 400.0) res = "CPU3이 스트레이트로 승리했습니다!";
			else if(plHandrank == 300.0) res = "CPU3이 트리플로 승리했습니다!";
			else if(plHandrank == 200.0) res = "CPU3이 투페어로 승리했습니다!";
			else if(plHandrank == 100.0) res = "CPU3이 원페어로 승리했습니다!";
			else res = "CPU3이 하이카드로 승리했습니다!";
			lblTrun.setText(res);
			cpu3Point += dao.fieldMoney;
			if(point < 0 || cpu1Point < 0 || cpu2Point < 0) {
				JOptionPane.showConfirmDialog(frame, "CPU3이 게임에서 승리했습니다!","돌아가기",JOptionPane.WARNING_MESSAGE);
				frame.dispose();
				new THAccountSelect();
				return res;
			}
		}
		dao.originFieldMoney += 5;
		dao.fieldMoney = dao.originFieldMoney;
		plCnt = 0;
		gameCnt = 0;
//		판돈만큼 포인트 차감
		point -= dao.originFieldMoney;
		cpu1Point -= dao.originFieldMoney;
		cpu2Point -= dao.originFieldMoney;
		cpu3Point -= dao.originFieldMoney;
		lblPlPoint.setText(point+"");
		lblCpu1Point.setText(cpu1Point+"");
		lblCpu2Point.setText(cpu2Point+"");
		lblCpu3Point.setText(cpu3Point+"");
		frame.repaint();
//		차감한만큼 판돈 추가
		dao.fieldMoney += dao.originFieldMoney*4;
		lblFieldPoint.setText(dao.fieldMoney+"");
		frame.setVisible(true);
		frame.repaint();
		
		new javax.swing.Timer(2000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ((javax.swing.Timer)e.getSource()).stop();
        resetGame();
      }
		}).start();
		return res;
	}
	
	private void resetGame() {
		service.cardDealStart();
		
		lblPL1.setIcon(new ImageIcon(getClass().getResource(service.getPlHand1().getImagePath())));
		lblPL2.setIcon(new ImageIcon(getClass().getResource(service.getPlHand2().getImagePath())));
		lblCpu11.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu12.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu21.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu22.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu31.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblCpu32.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField1.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField2.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField3.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField4.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		lblField5.setIcon(new ImageIcon(THGameStart.class.getResource("/TH/images/back.jpg")));
		frame.repaint();
		
		plCnt = 0;
		gameCnt = 0;
		
		rdRaise.setEnabled(true);
		rdCall.setEnabled(true);
		rdFold.setEnabled(true);
		btnAction.setEnabled(true);
	}
}

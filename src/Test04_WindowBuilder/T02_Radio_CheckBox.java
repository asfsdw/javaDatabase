package Test04_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T02_Radio_CheckBox {
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public static void main(String[] args) {
		new T02_Radio_CheckBox();
	}
	
	public T02_Radio_CheckBox() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("라디오 / 체크박스 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.CYAN);
		pn1.setBounds(12, 10, 760, 85);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("라디오버튼 / 체크박스 연습");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 736, 65);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(12, 105, 760, 351);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 25));
		lblGender.setBounds(26, 33, 97, 41);
		pn2.add(lblGender);
		
		JLabel lblHobby = new JLabel("취미");
		lblHobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobby.setFont(new Font("굴림", Font.BOLD, 25));
		lblHobby.setBounds(26, 122, 97, 41);
		pn2.add(lblHobby);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setFont(new Font("굴림", Font.BOLD, 25));
		rdbtnMale.setBounds(149, 33, 90, 41);
		pn2.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setSelected(true);
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setFont(new Font("굴림", Font.BOLD, 25));
		rdbtnFemale.setBounds(265, 33, 90, 41);
		pn2.add(rdbtnFemale);
		
		JCheckBox ckHobby1 = new JCheckBox("등산");
		ckHobby1.setBackground(Color.WHITE);
		ckHobby1.setFont(new Font("굴림", Font.BOLD, 25));
		ckHobby1.setBounds(149, 122, 90, 41);
		pn2.add(ckHobby1);
		
		JCheckBox ckHobby2 = new JCheckBox("낚시");
		ckHobby2.setBackground(Color.WHITE);
		ckHobby2.setFont(new Font("굴림", Font.BOLD, 25));
		ckHobby2.setBounds(265, 122, 90, 41);
		pn2.add(ckHobby2);
		
		JCheckBox ckHobby3 = new JCheckBox("수영");
		ckHobby3.setBackground(Color.WHITE);
		ckHobby3.setFont(new Font("굴림", Font.BOLD, 25));
		ckHobby3.setBounds(381, 122, 90, 41);
		pn2.add(ckHobby3);
		
		JCheckBox ckHobby4 = new JCheckBox("바둑");
		ckHobby4.setBackground(Color.WHITE);
		ckHobby4.setFont(new Font("굴림", Font.BOLD, 25));
		ckHobby4.setBounds(497, 122, 90, 41);
		pn2.add(ckHobby4);
		
		JCheckBox ckHobby5 = new JCheckBox("바이크");
		ckHobby5.setBackground(Color.WHITE);
		ckHobby5.setFont(new Font("굴림", Font.BOLD, 25));
		ckHobby5.setBounds(613, 122, 115, 41);
		pn2.add(ckHobby5);
		
		JLabel lblMessage = new JLabel("메시지 출력");
		lblMessage.setFont(new Font("굴림", Font.BOLD, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 218, 736, 123);
		pn2.add(lblMessage);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.PINK);
		pn3.setBounds(12, 466, 760, 85);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnGender = new JButton("성별출력");
		btnGender.setFont(new Font("굴림", Font.BOLD, 18));
		btnGender.setBounds(82, 20, 143, 42);
		pn3.add(btnGender);
		
		JButton btnHobby = new JButton("취미출력");
		btnHobby.setFont(new Font("굴림", Font.BOLD, 18));
		btnHobby.setBounds(307, 20, 143, 42);
		pn3.add(btnHobby);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 18));
		btnExit.setBounds(532, 20, 143, 42);
		pn3.add(btnExit);
		
		frame.setVisible(true);
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료하겠습니까?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
		
//		성별출력 버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "선택한 성별 : ";
				if(rdbtnMale.isSelected()) gender += rdbtnMale.getText();
				else gender += rdbtnFemale.getText();
				lblMessage.setText(gender);
			}
		});
		
//		취미출력 버튼
		btnHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hobby = "선택한 취미 : ";
				if(ckHobby1.isSelected()) hobby += ckHobby1.getText() + "/";
				if(ckHobby2.isSelected()) hobby += ckHobby2.getText() + "/";
				if(ckHobby3.isSelected()) hobby += ckHobby3.getText() + "/";
				if(ckHobby4.isSelected()) hobby += ckHobby4.getText() + "/";
				if(ckHobby5.isSelected()) hobby += ckHobby5.getText() + "/";
				hobby = hobby.substring(0, hobby.length()-1);
				lblMessage.setText(hobby);
			}
		});
	}
}

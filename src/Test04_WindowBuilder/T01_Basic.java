package Test04_WindowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class T01_Basic {
	private JFrame frame;
	private JTextField txtMid;
	private JPasswordField txtPwd;
	private JTextField txtName;
	private JTextField txtAge;
	public static void main(String[] args) {
		new T01_Basic();
	}
	public T01_Basic() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 600);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInput = new JButton("회원가입");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(46, 482, 200, 40);
		frame.getContentPane().add(btnInput);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(292, 482, 200, 40);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(538, 482, 200, 40);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("나이");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 225, 205, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(63, 160, 205, 55);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(63, 95, 205, 55);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_3.setBounds(63, 30, 205, 55);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.BOLD, 20));
		txtMid.setBounds(258, 30, 405, 55);
		frame.getContentPane().add(txtMid);
		txtMid.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("굴림", Font.BOLD, 20));
		txtPwd.setBounds(258, 95, 405, 55);
		frame.getContentPane().add(txtPwd);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.BOLD, 20));
		txtName.setColumns(10);
		txtName.setBounds(258, 160, 405, 55);
		frame.getContentPane().add(txtName);
		
		txtAge = new JTextField();
		txtAge.setText("0");
		txtAge.setFont(new Font("굴림", Font.BOLD, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(258, 225, 405, 55);
		frame.getContentPane().add(txtAge);
		
		JLabel lblNewLabel_4 = new JLabel("자기소개");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_4.setBounds(63, 290, 205, 55);
		frame.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 290, 405, 166);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtaContent = new JTextArea();
		txtaContent.setFont(new Font("굴림", Font.BOLD, 20));
		scrollPane.setViewportView(txtaContent);
		
		
		frame.setVisible(true);
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
//		회원가입버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText(), name = txtName.getText(), pwd = txtPwd.getText(), content = txtaContent.getText();
				int age = Integer.parseInt(txtAge.getText());
				
				if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디는 필수입력입니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
					txtMid.requestFocus();
				}
				else if(pwd.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호는 필수입력입니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
					txtPwd.requestFocus();
				}
				else if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "이름은 필수입력입니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
					txtName.requestFocus();
				}
				else JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}

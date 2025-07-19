package TH;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class THAccountCreate {
	private JFrame frame;
	private THVO vo = null;
	private THDAO dao = new THDAO();
	
	public THAccountCreate() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("계정생성");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 72);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("계정생성");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 736, 52);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(12, 92, 760, 377);
		frame.getContentPane().add(pn2);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.BOLD, 20));
		lblId.setBounds(92, 137, 130, 61);
		pn2.add(lblId);
		
		JTextPane txtId = new JTextPane();
		txtId.setFont(new Font("굴림", Font.BOLD, 20));
		txtId.setBounds(314, 137, 194, 61);
		pn2.add(txtId);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(12, 479, 760, 72);
		frame.getContentPane().add(pn3);
		
		JButton btnCreate = new JButton("계정생성");
		btnCreate.setFont(new Font("굴림", Font.BOLD, 20));
		btnCreate.setBounds(92, 10, 130, 52);
		pn3.add(btnCreate);
		
		JButton btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(314, 10, 130, 52);
		pn3.add(btnReset);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("굴림", Font.BOLD, 20));
		btnCancel.setBounds(536, 10, 130, 52);
		pn3.add(btnCancel);
		
		frame.setVisible(true);
		
//		계정생성
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				String id = txtId.getText().trim();
				if(id.equals("")) {
					JOptionPane.showMessageDialog(frame, "아이디를 입력해주세요.");
					txtId.requestFocus();
					return;
				}
				else if(!Pattern.matches("^[a-zA-Z가-힣]{1,3}$", id)) {
					JOptionPane.showMessageDialog(frame, "아이디는 영어 대, 소문자, 한글 3글자로 만들어주세요.");
					txtId.requestFocus();
					return;
				}
				vo = dao.getIdSearch(id);
				if(vo != null && vo.getName() != null) {
					JOptionPane.showMessageDialog(frame, "이미 있는 아이디입니다.");
					txtId.requestFocus();
					return;
				}
				vo = new THVO();
				vo.setName(id);
				
				res = dao.setAccountCreate(vo);
				
				if(res != 0) {
					JOptionPane.showMessageDialog(frame, "계정이 등록되었습니다.");
					frame.dispose();
					new THAccountSelect();
				}
				else {
					JOptionPane.showMessageDialog(frame, "계정 등록에 실패했습니다.");
					txtId.requestFocus();
				}
			}
		});
		btnCreate.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					int res = 0;
					String id = txtId.getText().trim();
					if(id.equals("")) {
						JOptionPane.showMessageDialog(frame, "아이디를 입력해주세요.");
						txtId.requestFocus();
						return;
					}
					else if(!Pattern.matches("^[a-zA-Z가-힣]{1,3}$", id)) {
						JOptionPane.showMessageDialog(frame, "아이디는 영어 대, 소문자, 한글 3글자로 만들어주세요.");
						txtId.requestFocus();
						return;
					}
					vo = dao.getIdSearch(id);
					if(vo != null && vo.getName() != null) {
						JOptionPane.showMessageDialog(frame, "이미 있는 아이디입니다.");
						txtId.requestFocus();
						return;
					}
					vo = new THVO();
					vo.setName(id);
					
					res = dao.setAccountCreate(vo);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(frame, "계정이 등록되었습니다.");
						frame.dispose();
						new THAccountSelect();
					}
					else {
						JOptionPane.showMessageDialog(frame, "계정 등록에 실패했습니다.");
						txtId.requestFocus();
					}
				}
			}
		});
		txtId.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					int res = 0;
					String id = txtId.getText().trim();
					if(id.equals("")) {
						JOptionPane.showMessageDialog(frame, "아이디를 입력해주세요.");
						txtId.requestFocus();
						return;
					}
					else if(!Pattern.matches("^[a-zA-Z가-힣]{1,3}$", id)) {
						JOptionPane.showMessageDialog(frame, "아이디는 영어 대, 소문자, 한글 3글자로 만들어주세요.");
						txtId.requestFocus();
						return;
					}
					vo = dao.getIdSearch(id);
					if(vo != null && vo.getName() != null) {
						JOptionPane.showMessageDialog(frame, "이미 있는 아이디입니다.");
						txtId.requestFocus();
						return;
					}
					vo = new THVO();
					vo.setName(id);
					
					res = dao.setAccountCreate(vo);
					
					if(res != 0) {
						JOptionPane.showMessageDialog(frame, "계정이 등록되었습니다.");
						frame.dispose();
						new THAccountSelect();
					}
					else {
						JOptionPane.showMessageDialog(frame, "계정 등록에 실패했습니다.");
						txtId.requestFocus();
					}
				}
			}
		});
		
//		다시입력
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtId.requestFocus();
			}
		});
		btnCancel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					txtId.setText("");
					txtId.requestFocus();
				}
			}
		});
		
//		취소
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THAccountSelect();
			}
		});
		btnCancel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					frame.dispose();
					new THAccountSelect();
				}
			}
		});
	}
}

package Test05_Insa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsaInput {
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private InsaVO vo = null;
	private InsaDAO dao = new InsaDAO(); 
	
	private int res = 0;
	
	public static void main(String[] args) {
		new InsaInput();
	}
	public InsaInput() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("사원 정보 입력");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 84);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("사원 정보 기입");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 736, 64);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 104, 760, 353);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.BOLD, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(76, 37, 112, 41);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.BOLD, 20));
		lblAge.setBounds(76, 115, 112, 41);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 20));
		lblGender.setBounds(76, 193, 112, 41);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.BOLD, 20));
		lblIpsail.setBounds(76, 271, 112, 41);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("굴림", Font.BOLD, 20));
		txtName.setBounds(229, 37, 325, 41);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("굴림", Font.BOLD, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(229, 115, 325, 41);
		pn2.add(txtAge);
		
		JRadioButton rdMale = new JRadioButton("남자");
		buttonGroup.add(rdMale);
		rdMale.setFont(new Font("굴림", Font.BOLD, 20));
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdMale.setBounds(229, 193, 137, 41);
		pn2.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		rdFemale.setSelected(true);
		buttonGroup.add(rdFemale);
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdFemale.setFont(new Font("굴림", Font.BOLD, 20));
		rdFemale.setBounds(417, 193, 137, 41);
		pn2.add(rdFemale);
		
//		년, 월, 일 초기값
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi = 2025;
		
		for(int i=0; i<yy.length; i++) {
			yy[i] = imsi - i +"";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i] = i + 1 +"";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i] = i + 1 +"";
		}
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("Dialog", Font.BOLD, 18));
		cbYY.setBounds(229, 271, 79, 41);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("Dialog", Font.BOLD, 18));
		cbMM.setBounds(341, 271, 79, 41);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("Dialog", Font.BOLD, 18));
		cbDD.setBounds(454, 271, 79, 41);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.BOLD, 20));
		lblYY.setBounds(308, 271, 21, 41);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("굴림", Font.BOLD, 20));
		lblMM.setBounds(420, 271, 21, 41);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("굴림", Font.BOLD, 20));
		lblDD.setBounds(533, 271, 21, 41);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 467, 760, 84);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("기입완료");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(81, 10, 145, 64);
		pn3.add(btnInput);
		
		JButton btnRest = new JButton("다시입력");
		btnRest.setFont(new Font("굴림", Font.BOLD, 20));
		btnRest.setBounds(307, 10, 145, 64);
		pn3.add(btnRest);
		
		JButton btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 20));
		btnClose.setBounds(533, 10, 145, 64);
		pn3.add(btnClose);
		
		frame.setVisible(true);

//		창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaMain();
			}
		});
		
//		가입하기 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
//				유효성 검사
				if(name.equals("")) {
					JOptionPane.showMessageDialog(frame, "이름을 입력해주세요,");
					txtName.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력해주세요,");
					txtAge.requestFocus();
				}
				else {
					if(rdMale.isSelected()) gender = "남자";
					else gender = "여자";
				}
				
//				회원명 중복처리
				vo = dao.getNameSearch(name);
				if(vo.getName() != null) {
					JOptionPane.showMessageDialog(frame, "이미 있는 이름입니다.");
					txtName.requestFocus();
				}
//				중복처리 완료 후
				vo = new InsaVO();
				vo.setName(name); 
				vo.setAge(Integer.parseInt(age));
				vo.setGender(gender);
				vo.setIpsail(ipsail);
				
				res = dao.setInsaInput(vo);
				
				if(res != 0) {
					JOptionPane.showMessageDialog(frame, "회원가입이 완료되었습니다.");
					frame.dispose();
					new InsaMain();
				}
				else {
					JOptionPane.showMessageDialog(frame, "회원가입에 실패했습니다.");
					txtName.requestFocus();
				}
			}
		});
	}
}

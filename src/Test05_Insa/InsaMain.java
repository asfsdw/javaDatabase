package Test05_Insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InsaMain {

	private JFrame frame;
	public static void main(String[] args) {
		new InsaMain();
	}
	public InsaMain() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("인사");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 79);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("인사관리프로그램 (v1.0)");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 736, 59);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 99, 760, 362);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(InsaMain.class.getResource("/Test04_WindowBuilder/images/01.png")));
		lblLogo.setBounds(0, 0, 760, 362);
		pn2.add(lblLogo);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 472, 760, 79);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(44, 10, 135, 59);
		pn3.add(btnInput);
		
		JButton btnSerch = new JButton("사원조회");
		btnSerch.setFont(new Font("굴림", Font.BOLD, 20));
		btnSerch.setBounds(223, 10, 135, 59);
		pn3.add(btnSerch);
		
		JButton btnList = new JButton("전체조회");
		btnList.setFont(new Font("굴림", Font.BOLD, 20));
		btnList.setBounds(402, 10, 135, 59);
		pn3.add(btnList);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(581, 10, 135, 59);
		pn3.add(btnExit);
		
		frame.setVisible(true);
		
//		종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료하겠습니까?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
		
//		사원등록 버튼
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaInput();
			}
		});
		
//		사원조회 버튼
		btnSerch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 이름을 입력해주세요.");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(frame, "검색한 사원이 존재하지 않습니다.");
				else {
					frame.dispose();
					new InsaSearch(vo);
				}
			}
		});
		
//		전체조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaList();
			}
		});
	}
}

package Test04_WindowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Test05_Insa.InsaDAO;
import Test05_Insa.InsaVO;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class T07_JTable {
	private JFrame frame;
	private JTable table;
	private Vector title, vData;
	private InsaDAO dao = new InsaDAO();
	private DefaultTableModel dtm;
	
	public static void main(String[] args) {
		new T07_JTable();
	}
	public T07_JTable() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("JTable 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 69);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("JTable 연습");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 480, 69);
		pn1.add(lblTitle);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 25));
		btnExit.setBounds(654, 0, 106, 69);
		pn1.add(btnExit);
		
		JButton btnn = new JButton("선택 셀의 레코드");
		btnn.setFont(new Font("굴림", Font.PLAIN, 15));
		btnn.setBounds(492, 0, 150, 69);
		pn1.add(btnn);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(12, 89, 760, 383);
		frame.getContentPane().add(pn2);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(12, 482, 760, 69);
		frame.getContentPane().add(pn3);
		
		JLabel lblMassage = new JLabel("New label");
		lblMassage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMassage.setFont(new Font("굴림", Font.BOLD, 20));
		lblMassage.setBounds(0, 0, 760, 69);
		
		pn3.add(lblMassage);
		
//		JTable 설계:JTable 제작시, '제목(필드명)'과 '데이터'를 설계하여 Vector 객체 타입으로 준비한다.
//		1.'제목'을 Vector 에 저장
		title = new Vector();
		title.add("번호");
		title.add("이름");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
//		2.'데이터'를 Vector 로 준비. 데이터는 DB에서 가져온다.
		vData = dao.getInsaList("","");
		
//		3.DB에서 가져온 자료(vData)와 title 을 DefaultTableModel 객체 생성 시, 할당한다.
		dtm = new DefaultTableModel(vData, title); // (데이터, 타이틀)
		
//		4.DefaultTableModel 에 담긴 Vector 타입의 '데이터와 타이틀'을 JTable 객체 생성 시, 담아준다.
		table = new JTable(dtm);
		
//		5.자료가 담긴 JTable 을 JScrollPane 객체 생성시에 담아준다.
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 760, 383);
		pn2.add(scrollPane);
		
		frame.setVisible(true);
		
//		JTable 에서 자료를 선택하면 해당 레코드의 정보 출력
		btnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				System.out.println("선택된 행의 정보 : "+row);
				if(row != -1) {
					InsaVO vo = dao.getNameSearch(table.getValueAt(row, 1)+"");
					String temp = "이름 : "+vo.getName()+", 나이 : "+vo.getAge()+", 성별 : "+vo.getGender()+", 입사일 : "+vo.getIpsail().substring(0, 10);
					lblMassage.setText(temp);
				}
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료하겠습니까?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
	}
}

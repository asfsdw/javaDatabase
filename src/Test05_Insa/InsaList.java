package Test05_Insa;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class InsaList {
	private JFrame frame;
	private JTable table;
	private Vector title, vData;
	private InsaDAO dao = new InsaDAO();
	private DefaultTableModel dtm;
	private JTextField textCondition;
	
	public InsaList() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("사원 리스트");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 57);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JButton btnList = new JButton("전체정렬");
		btnList.setFont(new Font("굴림", Font.BOLD, 25));
		btnList.setBounds(501, 0, 150, 57);
		pn1.add(btnList);
		
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("","");
				dtm.setDataVector(vData, title);
			}
		});
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 25));
		btnExit.setBounds(663, 0, 97, 57);
		pn1.add(btnExit);
		
		JComboBox cbCondition = new JComboBox();
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"이름", "나이", "성별", "입사일"}));
		cbCondition.setFont(new Font("굴림", Font.BOLD, 20));
		cbCondition.setBounds(0, 0, 132, 57);
		pn1.add(cbCondition);
		
		textCondition = new JTextField();
		textCondition.setFont(new Font("굴림", Font.BOLD, 20));
		textCondition.setBounds(144, 0, 150, 57);
		pn1.add(textCondition);
		textCondition.setColumns(10);
		
		JButton btnCondition = new JButton("검색");
		btnCondition.setFont(new Font("굴림", Font.BOLD, 25));
		btnCondition.setBounds(306, 0, 150, 57);
		pn1.add(btnCondition);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(12, 77, 760, 407);
		frame.getContentPane().add(pn2);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(12, 494, 760, 57);
		frame.getContentPane().add(pn3);
		
		JButton btnIpsailAsc = new JButton("입사일 오름차순");
		btnIpsailAsc.setFont(new Font("굴림", Font.PLAIN, 15));
		btnIpsailAsc.setBounds(448, 0, 150, 57);
		pn3.add(btnIpsailAsc);
		
		JButton btnIpsailDesc = new JButton("입사일 내림차순");
		btnIpsailDesc.setFont(new Font("굴림", Font.PLAIN, 15));
		btnIpsailDesc.setBounds(610, 0, 150, 57);
		pn3.add(btnIpsailDesc);
		
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
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료하겠습니까?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) frame.dispose(); new InsaMain();
			}
		});
		
//		입사일 오름차순 버튼
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail","asc");
				dtm.setDataVector(vData, title);	// 새로 생성하는 게 아니라 정렬만 바꾸는 것이기 때문에 set 으로 데이터와 타이틀을 바꿔준다.
			}
		});

//		입사일 내림차순 버튼
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList("ipsail","desc");
				dtm.setDataVector(vData, title);
			}
		});
		
//		조건검색 버튼
		btnCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String condition = cbCondition.getSelectedItem()+"",
						txtCondition = textCondition.getText();
				if(txtCondition.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "검색할 내용을 입력해주세요.");
					textCondition.requestFocus();
					return;
				}
				if(condition.equals("이름")) vData = dao.getConditionSearch("name", txtCondition);
				else if(condition.equals("나이")) {
					if(!Pattern.matches("^[0-9]+$", txtCondition)) {
						JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력해주세요,");
						textCondition.requestFocus();
					}
					else vData = dao.getConditionSearch("gender", txtCondition);
				}
				else if(condition.equals("성별")) vData = dao.getConditionSearch("gender", txtCondition);
				else if(condition.equals("입사일")) vData = dao.getConditionSearch("ipsail", txtCondition);
				dtm.setDataVector(vData, title);
			}
		});
	}
}

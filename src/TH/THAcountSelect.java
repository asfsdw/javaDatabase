package TH;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "rawtypes", "unused", "unchecked"})
public class THAcountSelect {
	private JFrame frame;
	private JTable table;
	private Vector vData, title;
	private DefaultTableModel dtm;
	private THDAO dao = new THDAO();
	
	public static void main(String[] args) {
		new THAcountSelect();
	}
	public THAcountSelect() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("계정선택");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("계정생성");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(100, 459, 127, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("계정삭제");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1.setBounds(327, 459, 127, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("게임시작");
		btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(554, 459, 127, 57);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("계정을 선택해서 게임을 시작하거나 계정이 없다면 계정을 생성하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 23, 760, 57);
		frame.getContentPane().add(lblNewLabel);
		
		title = new Vector();
		title.add("번호");
		title.add("아이디");
		title.add("포인트");
		
		vData = dao.getPlList();
		dtm = new DefaultTableModel(vData, title);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 90, 581, 318);
		frame.getContentPane().add(scrollPane);
		
		frame.setVisible(true);
		
	}
}

package Test04_WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class T03_ComboBox_List {

	private JFrame frame;
	public static void main(String[] args) {
		T03_ComboBox_List window = new T03_ComboBox_List();
		window.frame.setVisible(true);
	}
	public T03_ComboBox_List() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("콤보상자/리스트 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 373, 362);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("직업을 선택하세요");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 349, 39);
		pn1.add(lblTitle);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학생", "의사", "변호사", "회계사", "군인", "회사원", "공무원", "간호사", "자영업", "기타"}));
		comboJob.setFont(new Font("굴림", Font.BOLD, 20));
		comboJob.setBounds(12, 73, 349, 39);
		pn1.add(comboJob);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(397, 10, 375, 362);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 351, 102);
		pn2.add(scrollPane);
		
		JList listJob = new JList();
		listJob.setFont(new Font("굴림", Font.BOLD, 20));
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "군인", "회사원", "공무원", "간호사", "자영업", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 382, 760, 83);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnCombo = new JButton("콤보상자 출력");
		btnCombo.setFont(new Font("굴림", Font.BOLD, 16));
		btnCombo.setBounds(42, 10, 137, 63);
		pn3.add(btnCombo);
		
		JButton btnList = new JButton("리스트 출력");
		btnList.setFont(new Font("굴림", Font.BOLD, 16));
		btnList.setBounds(221, 10, 137, 63);
		pn3.add(btnList);
		
		JButton btnMess = new JButton("메시지 출력");
		btnMess.setFont(new Font("굴림", Font.BOLD, 16));
		btnMess.setBounds(400, 10, 137, 63);
		pn3.add(btnMess);
		
		JButton btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 16));
		btnExit.setBounds(579, 10, 137, 63);
		pn3.add(btnExit);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(12, 468, 760, 83);
		frame.getContentPane().add(pn4);
		pn4.setLayout(null);
		
		JLabel lblMessage = new JLabel("메시지가 출력됩니다.");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("굴림", Font.BOLD, 20));
		lblMessage.setBounds(206, 20, 349, 39);
		
		pn4.add(lblMessage);
		
//		종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료하겠습니까?", "작업종료", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
		
//		직업 콤보박스를 선택할 때
		comboJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString()+"("+comboJob.getSelectedIndex()+"번 인덱스입니다.)";
				lblMessage.setText(msg);
			}
		});
		
//		리스트 출력할 때
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				Object[] jobs = listJob.getSelectedValuesList().toArray();
				for(Object job : jobs) msg += job + "/";
				msg = msg.substring(0, msg.length()-1);
				lblMessage.setText(msg);
			}
		});
	}
}

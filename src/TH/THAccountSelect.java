package TH;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "rawtypes", "unchecked", "serial"})
public class THAccountSelect {
	private JFrame frame;
	private JTable table;
	private Vector vData, title;
	private DefaultTableModel dtm;
	private THDAO dao = new THDAO();
	
	public THAccountSelect() {
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
		
		JButton btnCreate = new JButton("계정생성");
		btnCreate.setFont(new Font("굴림", Font.BOLD, 20));
		btnCreate.setBounds(55, 459, 127, 57);
		frame.getContentPane().add(btnCreate);
		
		JButton btnDelete = new JButton("계정삭제");
		btnDelete.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelete.setBounds(237, 459, 127, 57);
		frame.getContentPane().add(btnDelete);
		
		JButton btnGameStart = new JButton("게임시작");
		btnGameStart.setFont(new Font("굴림", Font.BOLD, 20));
		btnGameStart.setBounds(419, 459, 127, 57);
		frame.getContentPane().add(btnGameStart);
		
		JButton btnReturn = new JButton("타이틀로");
		btnReturn.setFont(new Font("굴림", Font.BOLD, 20));
		btnReturn.setBounds(601, 459, 127, 57);
		frame.getContentPane().add(btnReturn);
		
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
		dtm = new DefaultTableModel(vData, title) {
//			JTable 수정 불가 메소드 오버라이드
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 90, 581, 318);
		frame.getContentPane().add(scrollPane);
		
		frame.setVisible(true);
		
//		계정생성
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THAccountCreate();
			}
		});
		btnCreate.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					frame.dispose();
					new THAccountCreate();
				}
			}
		});
		
//		계정삭제
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int res = 0;
				if(row == -1) {
					JOptionPane.showMessageDialog(frame, "유저를 선택해주세요.","에러",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String id = table.getValueAt(row, 1)+"";
				res = JOptionPane.showConfirmDialog(frame, "유저를 삭제하시겠습니까?","경고",JOptionPane.YES_NO_OPTION);
				if(res == 0) {
					res = dao.setAccountDelete(id);
					JOptionPane.showMessageDialog(frame, "유저가 삭제되었습니다.");
					vData = dao.getPlList();
					dtm.setDataVector(vData, title);
				}
			}
		});
		btnDelete.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int row = table.getSelectedRow();
				int res = 0;
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					if(row == -1) {
						JOptionPane.showMessageDialog(frame, "유저를 선택해주세요.","에러",JOptionPane.WARNING_MESSAGE);
						return;
					}
					String id = table.getValueAt(row, 1)+"";
					res = JOptionPane.showConfirmDialog(frame, "유저를 삭제하시겠습니까?","경고",JOptionPane.YES_NO_OPTION);
					if(res == 0) {
						res = dao.setAccountDelete(id);
						JOptionPane.showMessageDialog(frame, "유저가 삭제되었습니다.");
						vData = dao.getPlList();
						dtm.setDataVector(vData, title);
					}
				}
			}
		});
	
//		게임시작
		btnGameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(frame, "유저를 선택해주세요.","에러",JOptionPane.WARNING_MESSAGE);
					return;
				}
				int point = Integer.parseInt(table.getValueAt(row, 2)+"");
				String id = table.getValueAt(row, 1)+"";
				if(point < 0) {
					JOptionPane.showMessageDialog(frame, "포인트가 없습니다!","에러",JOptionPane.WARNING_MESSAGE);
				}
				else {
					frame.dispose();
					new THGameStart(id, point);
				}
			}
		});
		btnGameStart.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int row = table.getSelectedRow();
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					if(row == -1) {
						JOptionPane.showMessageDialog(frame, "유저를 선택해주세요.","에러",JOptionPane.WARNING_MESSAGE);
						return;
					}
					int point = Integer.parseInt(table.getValueAt(row, 2)+"");
					String id = table.getValueAt(row, 1)+"";
					if(point < 0) {
						JOptionPane.showMessageDialog(frame, "포인트가 없습니다!","에러",JOptionPane.WARNING_MESSAGE);
					}
					else {
						frame.dispose();
						new THGameStart(id, point);
					}
				}
			}
		});
		
//		돌아가기
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new THRun();
			}
		});
		btnReturn.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == 10) {
					frame.dispose();
					new THRun();
				}
			}
		});
	}
}

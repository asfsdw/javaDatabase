package Test03_Swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T03_DialogBox extends JFrame {
	public T03_DialogBox() {
		super("스윙 연습");
		designView();
	}
	private void designView() {
		setSize(400, 350);
		setLocationRelativeTo(null);	// 윈도우 중앙에 배치
//		setDefaultCloseOperation(3);	// 윈도우 닫기버튼을 클릭해서 창닫기 수행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 위와 똑같은 기능이다.
		setResizable(false);	// 윈도우창 크기 고정(변경 불가), 기본 True
		
		setLayout(new GridLayout(2,1));
		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		pn1.setBackground(Color.GRAY);
		
		JButton btn1 = new JButton("경고");
		JButton btn2 = new JButton("입력");
		JButton btn3 = new JButton("종료");
		JButton btn4 = new JButton("종료(Y/N)");
		JButton btn5 = new JButton("종료(Y/N/C)");
		pn1.add(btn1);
		pn1.add(btn2);
		pn1.add(btn3);
		pn1.add(btn4);
		pn1.add(btn5);
		
		JLabel lblMessage = new JLabel("메시지가 출력됩니다.");
		pn2.add(lblMessage);
		
		add(pn1);
		add(pn2);
		
		setVisible(true);	// 화면 출력(없으면 view 화면 안 나옴)
		
//		경고 메시지 출력
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("경고버튼을 누르셨습니다.");
//				JOptionPane.showMessageDialog(null, lblMessage.getText());
				JOptionPane.showMessageDialog(null, lblMessage.getText(), "경고메시지" ,JOptionPane.WARNING_MESSAGE);
			}
		});
//		입력 출력
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("입력버튼을 누르셨습니다.");
				String name = JOptionPane.showInputDialog(null, "이름을 입력하세요.", "입력창", JOptionPane.DEFAULT_OPTION);
				if(name != null) lblMessage.setText("이름:"+name);
			}
		});
//		종료
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
//		예/아니오
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("Y/N버튼을 클릭하셨습니다.");
				int anser = JOptionPane.showConfirmDialog(null, "작업을 계속하시겠습니까?","작업종료창",JOptionPane.YES_NO_OPTION);
				if(anser == 0) {
					JOptionPane.showMessageDialog(null, "작업을 계속합니다.");
				}
				else {
					JOptionPane.showMessageDialog(null, "작업을 종료합니다.");
					System.exit(0);
				}
			}
		});
//		예/아니오/취소
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("Y/N/C버튼을 클릭하셨습니다.");
				int anser = JOptionPane.showConfirmDialog(null, "작업을 계속하시겠습니까?","작업종료창",JOptionPane.YES_NO_CANCEL_OPTION);
				if(anser == 0) {
					JOptionPane.showMessageDialog(null, "작업을 계속합니다.");
				}
				else if(anser == 1) {
					JOptionPane.showMessageDialog(null, "작업을 종료합니다.");
					System.exit(0);
				}
				else JOptionPane.showMessageDialog(null, "작업으로 돌아갑니다.");
			}
		});
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		});
	}
	public static void main(String[] args) {
		new T03_DialogBox();
	}
}
